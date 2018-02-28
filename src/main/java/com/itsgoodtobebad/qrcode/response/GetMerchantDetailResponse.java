package com.itsgoodtobebad.qrcode.response;

/**
 * @author liliangxi.
 *         Created on 2018/2/7.
 */
public class GetMerchantDetailResponse {
    /** 正式商户号，入网申请成功提交支付平台后存在 */
    private String mchtNo;
    /** 二维码牌编码 */
    private String qrTokenCode;
    /** 上级商户编号 */
    private String picUrl;
    /** 上级商户名称 */
    private String mchtMngNo;
    /** 商户类型：01企业法人 04个体工商 */
    private String mchtMngName;
    /**  */
    private String mchtType;
    /** 一级行业编号 */
    private String firCateCode;
    /** 二级行业编号 */
    private String secCateCode;
    /** 三级行业编号 */
    private String thdCateCode;
    /** 所属城市编号 */
    private String addressCode;
    /** 商户名称 */
    private String mchtName;
    /** 商户简称 */
    private String mchtSimpleName;
    /** 经营地址 */
    private String mchtContAddr;
    /** 联系人邮箱 */
    private String mchtEmail;
    /** 座机电话 */
    private String telephone;
    /** 联系人姓名 */
    private String mchtPersonName;
    /** 联系人手机号 */
    private String mchtPhone;
    /** 法定代表人姓名/店主姓名 */
    private String mchtArtifName;
    /** 法定代表人证件号 */
    private String mchtArtifId;
    /** 法定代表人证件生效日期，YYYY-MM-DD */
    private String artifSdate;
    /** 法定代表人证件失效日期，YYYY-MM-DD */
    private String artifEdate;
    /** 营业执照类别：01三证合一 02非三证合一 */
    private String mchtLicnType;
    /** 营业执照编号 */
    private String mchtLicnNo;
    /** 营业执照生效日期，YYYY-MM-DD */
    private String mchtLicnSdate;
    /**  */
    private String mchtLicnEdate;
    /**  */
    private String occNo;
    /**  */
    private String occSdate;
    /**  */
    private String occEdate;
    /**  */
    private String trcNo;
    /**  */
    private String trcSdate;
    /**  */
    private String trcEdate;
    /**  */
    private String serviceList;
    /**  */
    private String serviceID;
    /**  */
    private String rate;
    /**  */
    private String setlType;
    /**  */
    private String setlSymbol;
    /**  */
    private String specSetlDay;
    /**  */
    private String setlAcctType;
    /**  */
    private String accountBoss;
    /**  */
    private String setlAcctName;
    /**  */
    private String setlAcctNo;
    /**  */
    private String setlBankCode;
    /**  */
    private String setlBankName;
    /**  */
    private String setlSubBranchCode;
    /**  */
    private String setlSubBranchName;
    /**  */
    private String setlBankPhone;
    /**  */
    private String mchtPicUrlList;
    /**  */
    private String mchtPicType;
    /**  */
    private String mchtPicUrl;
    /**  */
    private String status;
    /**  */
    private String rejectedReason;
}
