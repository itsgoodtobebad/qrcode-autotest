package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi
 *         Created by Liliangxi on 2017/11/16.
 */
public class GetWxAuthPageRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/wxAuthPage";
    }


}
