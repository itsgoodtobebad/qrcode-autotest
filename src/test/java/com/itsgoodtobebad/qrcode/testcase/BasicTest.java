package com.itsgoodtobebad.qrcode.testcase;


import com.itsgoodtobebad.qrcode.mock.EmbeddedJettyServer;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;

/**
 * @author liliangxi.
 * Created by Liliangxi on 2017/9/20.
 */
public class BasicTest {
    {

    }

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    EmbeddedJettyServer mockServer;

    @BeforeSuite
    public void beforeSuite(){
        Configurations configs = new Configurations();
        try{
            Configuration config = configs.properties(new File("qrcode.properties"));
            RestAssured.baseURI = config.getString("RestAssured.baseURI");
            RestAssured.port = config.getInt("RestAssured.port");
            RestAssured.basePath = config.getString("RestAssured.basePath", "");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        // 开发环境
        //RestAssured.baseURI = "http://192.168.0.47";
        //RestAssured.port = 7501;

        // 测试环境
        //RestAssured.baseURI = "http://192.168.0.74";
        //RestAssured.basePath = "/testsit";
        //RestAssured.port = 7501;

        Configurations configs = new Configurations();
        try{
            Configuration config = configs.properties(new File("qrcode.properties"));
            RestAssured.baseURI = config.getString("RestAssured.baseURI");
            RestAssured.port = config.getInt("RestAssured.port");
            RestAssured.basePath = config.getString("RestAssured.basePath", "");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        RestAssured.registerParser("text/plain", Parser.JSON);
    }

    @AfterClass
    public void afterClass(){
        try{
            mockServer.stop();
        }catch (Exception e){
        }
    }
}
