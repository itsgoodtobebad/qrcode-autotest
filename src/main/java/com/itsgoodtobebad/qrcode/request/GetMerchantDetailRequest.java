package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author liliangxi.
 *         Created on 2018/1/17.
 */
public class GetMerchantDetailRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/merchants";
    }

    /** 平台分配唯一商户ID */
    private String mchtId;
    /** 查询类型：0-查询商户信息 1-查询商户审批信息 */
    private int type;

    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
