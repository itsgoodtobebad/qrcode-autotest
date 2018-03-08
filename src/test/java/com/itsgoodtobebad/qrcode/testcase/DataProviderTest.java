package com.itsgoodtobebad.qrcode.testcase;

import com.itsgoodtobebad.qrcode.filter.SetTimeStampAndSignFilter;
import com.itsgoodtobebad.qrcode.request.GetMerchantDetailRequest;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.configuration2.BaseHierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author liliangxi.
 *         Created on 2018/3/8.
 */
public class DataProviderTest extends BasicTest{
    @DataProvider(name="GetMerchantDetail")
    public Object[][] dataProvider() throws ConfigurationException {
        Configurations configs = new Configurations();
        XMLConfiguration config = configs.xml(new File(this.getClass().getClassLoader().getResource("testcase/QueryMerchantDetail/testcases.xml").getFile()));
        List cases = config.configurationsAt("testcase.input");
        Object[][] params = new Object[cases.size()][2];
        for(int i = 0;i < cases.size();i++)
        {
            BaseHierarchicalConfiguration sub = (BaseHierarchicalConfiguration)cases.get(i);
            String mchtId = sub.getString("mchtId");
            int type = sub.getInt("type");


            params[i] = new Object[] {mchtId, type};
        }
        return params;
    }



    @Test(dataProvider = "GetMerchantDetail")
    public void GetMerchantDetailTest_Basic(String mchtId, int type){
        GetMerchantDetailRequest req = new GetMerchantDetailRequest();
        req.setMchtId(mchtId);
        req.setType(type);

        ValidatableResponse response =
                given().headers(req.headers)
                        .param("type", req.getType())
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .log().all()
                        .when()
                        .get(req.getUri() + "/" + req.getMchtId())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("code", equalTo("0000"));

    }
}
