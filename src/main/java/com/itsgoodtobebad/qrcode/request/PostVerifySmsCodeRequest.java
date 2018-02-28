package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi.
 *         Created on 2017/11/16.
 */
public class PostVerifySmsCodeRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/verifySmsCode";
    }

    private String serviceToken;
    private String smsCode;

    public String getServiceToken() {
        return serviceToken;
    }

    public void setServiceToken(String serviceToken) {
        this.serviceToken = serviceToken;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
