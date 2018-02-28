package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author liliangxi.
 *         Created on 2018/1/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModifyMerchantRequest extends PostMerchantsRequest{
    private String mchtId;
    private int opType;

    public String getMchtId() {
        return mchtId;
    }

    public void setMchtId(String mchtId) {
        this.mchtId = mchtId;
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }
}
