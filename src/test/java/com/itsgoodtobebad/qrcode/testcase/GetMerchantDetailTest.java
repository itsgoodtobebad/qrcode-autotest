package com.itsgoodtobebad.qrcode.testcase;

import com.itsgoodtobebad.qrcode.request.GetMerchantDetailRequest;
import com.itsgoodtobebad.qrcode.filter.SetTimeStampAndSignFilter;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.configuration2.BaseHierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author liliangxi.
 *         Created on 2018/1/17.
 */
public class GetMerchantDetailTest extends BasicTest{

    @Test
    public void GetMerchantDetailTest(){
        GetMerchantDetailRequest req = new GetMerchantDetailRequest();
        req.setMchtId("EEsFDn4201643257270108166");
        req.setType(0);

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
