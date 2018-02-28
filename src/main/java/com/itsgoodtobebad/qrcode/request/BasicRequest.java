package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Liliangxi on 2017/9/19.
 */
public class BasicRequest {
    @JsonIgnore
    public String callerId;
    @JsonIgnore
    public String appKey;
    @JsonIgnore
    public String appSecret;
    @JsonIgnore
    public String accessToken;
    @JsonIgnore
    public String serSignKey;
    @JsonIgnore
    public String userID;


     {
        Configurations configs = new Configurations();
        try{
            Configuration config = configs.properties(new File("qrcode.properties"));
            callerId = config.getString("callerId");
            appKey = config.getString("appKey");
            appSecret = config.getString("appSecret");
            serSignKey = config.getString("serSignKey");
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    @JsonIgnore
    public Map<String, String> headers = new HashMap<String, String>(){{
        put("Content-Type", "application/json;charset=UTF-8");
        put("appKey", appKey);
        put("callerID", callerId);
        //put("auth", "Token=" + accessToken);
        //put("userID", userID);
    }};

}
