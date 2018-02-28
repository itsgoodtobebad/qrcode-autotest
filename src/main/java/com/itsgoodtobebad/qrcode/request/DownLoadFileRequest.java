package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi.
 *         Created on 2018/1/16.
 */
public class DownLoadFileRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/fileapi/1.0/download";
    }
}
