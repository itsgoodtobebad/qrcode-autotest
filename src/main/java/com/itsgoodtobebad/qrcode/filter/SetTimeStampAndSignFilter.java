package com.itsgoodtobebad.qrcode.filter;

import com.itsgoodtobebad.qrcode.utils.DateTimeUtils;
import com.itsgoodtobebad.qrcode.utils.HttpUtil;
import com.itsgoodtobebad.qrcode.utils.SecurityUtils;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import io.restassured.spi.AuthFilter;
import java.util.Map;

/**
 * Created by Liliangxi on 2017/8/15.
 */
public class SetTimeStampAndSignFilter implements AuthFilter {
    private String appkey;
    private String appsecret;

    public SetTimeStampAndSignFilter(String appkey, String appsecret){
        this.appkey = appkey;
        this.appsecret = appsecret;
    }

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {

        String timeStamp = DateTimeUtils.getUTCTimestamp("yyyyMMdd.HHmmss");
        filterableRequestSpecification.header("timestamp", timeStamp);

        switch (filterableRequestSpecification.getMethod()){
            case "POST":
            case "PUT":
                String body = "";
                if(null != filterableRequestSpecification.getBody()){
                    body = filterableRequestSpecification.getBody().toString();
                }
                filterableRequestSpecification.header("sign", SecurityUtils.calcSign(timeStamp, appkey, appsecret, body));
                break;
            case "GET":
            case "DELETE":
                Map<String, String> parameterMap = filterableRequestSpecification.getRequestParams();
                String sortedQueryString = HttpUtil.buildSortedQuery(parameterMap);
                filterableRequestSpecification.header("sign", SecurityUtils.calcSign(timeStamp, appkey, appsecret, sortedQueryString));
                break;
            default:
        }
        return filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
    }
}
