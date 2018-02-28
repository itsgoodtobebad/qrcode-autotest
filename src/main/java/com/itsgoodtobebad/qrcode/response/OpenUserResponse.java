package com.itsgoodtobebad.qrcode.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Liliangxi on 2017/9/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OpenUserResponse {
    private String requestNo;            // 请求流水号, 接入合作商内部唯一
    private String userId;               // 平台生成的用户唯一ID
    private String partnerUserId;        // 合作商用户ID，接入合作商内部唯一
    private int needSMSVerification;     // 是否需要短信验证，0-不需要验证 1-需要验证（平台下发短信）
    private String serviceToken;         // 是否必填（否），业务授权令牌，用于用户后续流程

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPartnerUserId() {
        return partnerUserId;
    }

    public void setPartnerUserId(String partnerUserId) {
        this.partnerUserId = partnerUserId;
    }

    public int getNeedSMSVerification() {
        return needSMSVerification;
    }

    public void setNeedSMSVerification(int needSMSVerification) {
        this.needSMSVerification = needSMSVerification;
    }

    public String getServiceToken() {
        return serviceToken;
    }

    public void setServiceToken(String serviceToken) {
        this.serviceToken = serviceToken;
    }
}
