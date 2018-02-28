package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi.
 *         Created on 2018/1/15.
 */
public class GetMerchantsRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/merchants";
    }
}
