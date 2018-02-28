package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi.
 *         Created on 2017/11/17.
 */
public class PutAgentsRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/agents";
    }
/*
    private String agentId
    private String inviteCode
    private String agentType
    private String agentName
    private String address
    private String contactName
    private String contactPhone
    private String contactEmail
    private String artificialName
    private String artificialMobile
    private String artificialIdNo
    private String licenseNo
    private String setlAcctType
    private String setlAcctName
    private String setlAcctNo
    private String setlBankId
    private String setlBankName
    private String setlBankBindMobile
    private String serviceFeeMode
    private String agentPicList
    private String picType
    private String picUrl
    */
}
