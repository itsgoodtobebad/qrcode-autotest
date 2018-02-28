package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Created by Liliangxi on 2017/11/14.
 */
public class GetTokenRequest extends BasicRequest {
    public final String uri = "/agentapi/1.0/tokens";

    private String wxCode;

    @JsonIgnore
    public String getUri() {
        return uri;
    }

    public String getWxCode() {
        return wxCode;
    }

    public void setWxCode(String wxCode) {
        this.wxCode = wxCode;
    }
}
