package com.itsgoodtobebad.qrcode.testcase;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsgoodtobebad.qrcode.dbhelper.DBHelper;
import com.itsgoodtobebad.qrcode.dto.MerBase;
import com.itsgoodtobebad.qrcode.request.GetMerchantDetailRequest;
import com.itsgoodtobebad.qrcode.filter.SetTimeStampAndSignFilter;
import io.restassured.response.ValidatableResponse;
import org.apache.commons.configuration2.BaseHierarchicalConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    public void testreadconfig() throws ConfigurationException {
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
        System.out.println(Arrays.deepToString(params));

    }

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

    @Test
    public void GetMerchantDetailTest(){
        GetMerchantDetailRequest req = new GetMerchantDetailRequest();
        req.setMchtId("EEsFDn4115519473136435205");
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

    @Test
    public void test(){

/*        DBHelper helper = new DBHelper();
*//*        MerBase merBase = helper.queryMerchantByMchtPhone("13215252525");
        System.out.println(merBase.getMchtname());*//*
        helper.deleteMerchantFromMerBaseByMchtPhone("13423242342");*/

    }

    @Test
    public void test1(){
        try
        {
            XMLConfiguration config = new XMLConfiguration();
            config.read(new FileReader(new File("QueryMerchantDetail.xml")));

            String mchtId = config.getString("testcases.testcase.mchtId");
            System.out.println(mchtId);
            // do something with config
        }
        catch(ConfigurationException cex)
        {
            // something went wrong, e.g. the file was not found
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
