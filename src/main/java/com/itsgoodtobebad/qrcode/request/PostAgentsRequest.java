package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liliangxi.
 *         Created on 2017/11/16.
 */
public class PostAgentsRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/agents";
    }

    private String inviteCode;
    private int agentType;
    private String agentName;
    private String address;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String artificialName;
    private String artificialMobile;
    private String artificialIdNo;
    private String licenseNo;
    private int setlAcctType;
    private String setlAcctName;
    private String setlAcctNo;
    private String setlBankId;
    private String setlBankName;
    private String setlBankBindMobile;
    private String serviceFeeMode;
    private List<agentPic> agentPicList = new ArrayList<agentPic>();

    //region getter && setter

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public int getAgentType() {
        return agentType;
    }

    public void setAgentType(int agentType) {
        this.agentType = agentType;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getArtificialName() {
        return artificialName;
    }

    public void setArtificialName(String artificialName) {
        this.artificialName = artificialName;
    }

    public String getArtificialMobile() {
        return artificialMobile;
    }

    public void setArtificialMobile(String artificialMobile) {
        this.artificialMobile = artificialMobile;
    }

    public String getArtificialIdNo() {
        return artificialIdNo;
    }

    public void setArtificialIdNo(String artificialIdNo) {
        this.artificialIdNo = artificialIdNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public int getSetlAcctType() {
        return setlAcctType;
    }

    public void setSetlAcctType(int setlAcctType) {
        this.setlAcctType = setlAcctType;
    }

    public String getSetlAcctName() {
        return setlAcctName;
    }

    public void setSetlAcctName(String setlAcctName) {
        this.setlAcctName = setlAcctName;
    }

    public String getSetlAcctNo() {
        return setlAcctNo;
    }

    public void setSetlAcctNo(String setlAcctNo) {
        this.setlAcctNo = setlAcctNo;
    }

    public String getSetlBankId() {
        return setlBankId;
    }

    public void setSetlBankId(String setlBankId) {
        this.setlBankId = setlBankId;
    }

    public String getSetlBankName() {
        return setlBankName;
    }

    public void setSetlBankName(String setlBankName) {
        this.setlBankName = setlBankName;
    }

    public String getSetlBankBindMobile() {
        return setlBankBindMobile;
    }

    public void setSetlBankBindMobile(String setlBankBindMobile) {
        this.setlBankBindMobile = setlBankBindMobile;
    }

    public String getServiceFeeMode() {
        return serviceFeeMode;
    }

    public void setServiceFeeMode(String serviceFeeMode) {
        this.serviceFeeMode = serviceFeeMode;
    }

    public List<agentPic> getAgentPicList() {
        return agentPicList;
    }

    public void setAgentPicList(List<agentPic> agentPicList) {
        this.agentPicList = agentPicList;
    }

    //endregion getter && setter

    public class agentPic {
        private String picType;
        private String picUrl;

        public String getPicType() {
            return picType;
        }

        public void setPicType(String picType) {
            this.picType = picType;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public agentPic(String picType, String picUrl){
            this.picType = picType;
            this.picUrl = picUrl;
        }
    }
}


