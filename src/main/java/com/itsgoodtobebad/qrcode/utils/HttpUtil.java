package com.itsgoodtobebad.qrcode.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/**
 * Http相关工具类
 * @author majunhui
 * @date 2016/7/27.
 * */
public class HttpUtil {

    /**
     * 组装queryString串
     *
     * @param params 参数
     * @throws Exception
     */
    public static String buildQuery(Map<String, String> params) throws IOException {
        return buildQuery(params,true);
    }
    /**
     * 组装queryString串
     *
     * @param params 参数
     * @throws Exception
     */
    public static String buildQuery(Map<String, String> params, boolean needEncode) throws UnsupportedEncodingException {

        if (params == null || params.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            // 参数值为空的参数不传递
            if (value!=null && value.length()>0) {
                if (needEncode) {
                    sb.append(key+"="+ URLEncoder.encode(value, "UTF-8")+"&");
                } else {
                    sb.append(key+"="+ value+"&");
                }
            }
        }
        if (sb.length()>0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }


    /***
     * 根据Url的参数，计算排序后的QueryString
     * @param parameterMap
     * @return
     */
    public static String buildSortedQuery(Map<String, String> parameterMap){
        Map<String, String> sortMap = MapUtil.sortMapByKey(parameterMap);

        String sortedQueryString = "";
        try{
            sortedQueryString = HttpUtil.buildQuery(sortMap,false);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return sortedQueryString;
    }

    public static void main(String[] args) {

    }
}