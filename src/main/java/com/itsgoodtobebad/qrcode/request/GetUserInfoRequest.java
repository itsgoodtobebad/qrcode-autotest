package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi.
 *         Created on 2017/11/16.
 */
public class GetUserInfoRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/userInfo";
    }

}
