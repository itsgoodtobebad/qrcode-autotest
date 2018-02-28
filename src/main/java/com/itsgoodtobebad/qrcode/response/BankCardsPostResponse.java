package com.itsgoodtobebad.qrcode.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Liliangxi on 2017/9/20.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCardsPostResponse {

    private BankCardInfo bankCardInfo = new BankCardInfo();
    private int isNewCard = 1;
    private int needSMSVerification = 0;
    private String serviceToken;

    public BankCardInfo getBankCardInfo() {
        return bankCardInfo;
    }

    public void setBankCardInfo(BankCardInfo bankCardInfo) {
        this.bankCardInfo = bankCardInfo;
    }

    public int getIsNewCard() {
        return isNewCard;
    }

    public void setIsNewCard(int isNewCard) {
        this.isNewCard = isNewCard;
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

    public static class BankCardInfo {
        private int bankCardID;             // 银行卡ID，平台内部银行卡唯一标识
        private String bankCardNo;          // 银行卡号，带*号隐藏格式
        private String bankCardRef;         // 银行卡卡号内部统一标识
        private int bankCardType = 1;       // 银行卡类型，1_借记卡(储蓄卡)，2_贷记卡(信用卡)
        private String bankName;            // 银行名称
        private String iconCode;            // icon图标编码
        private String bankCode;            // 银行机构代码
        private int cardUseable = 1;        // 银行卡是否可用 1-可用 0-不可用

        public int getBankCardID() {
            return bankCardID;
        }

        public void setBankCardID(int bankCardID) {
            this.bankCardID = bankCardID;
        }

        public String getBankCardNo() {
            return bankCardNo;
        }

        public void setBankCardNo(String bankCardNo) {
            this.bankCardNo = bankCardNo;
        }

        public String getBankCardRef() {
            return bankCardRef;
        }

        public void setBankCardRef(String bankCardRef) {
            this.bankCardRef = bankCardRef;
        }

        public int getBankCardType() {
            return bankCardType;
        }

        public void setBankCardType(int bankCardType) {
            this.bankCardType = bankCardType;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getIconCode() {
            return iconCode;
        }

        public void setIconCode(String iconCode) {
            this.iconCode = iconCode;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public int getCardUseable() {
            return cardUseable;
        }

        public void setCardUseable(int cardUseable) {
            this.cardUseable = cardUseable;
        }
    }


}


