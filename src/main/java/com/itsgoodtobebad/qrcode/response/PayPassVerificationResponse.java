package com.itsgoodtobebad.qrcode.response;

/**
 * Created by Liliangxi on 2017/9/21.
 */
public class PayPassVerificationResponse {
    private String pinToken;                    // 验证成功后台生成的Token

    public String getPinToken() {
        return pinToken;
    }

    public void setPinToken(String pinToken) {
        this.pinToken = pinToken;
    }
}
