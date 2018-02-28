package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi.
 *         Created on 2018/1/15.
 */
public class PostFileRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/fileapi/1.0/upload";
    }
}
