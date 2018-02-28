package com.itsgoodtobebad.qrcode.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liliangxi.
 *         Created on 2018/1/11.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostMerchantsRequest extends BasicRequest{
    @JsonIgnore
    public String getUri() {
        return "/agentapi/1.0/merchants";
    }

    /** 二维码，预先分配二维码牌的商户必填 */
    private String qrTokenCode;
    /** 上级商户号 */
    private String mchtMngNo;
    /** 商户类型 01企业法人 04个体工商 */
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
    /** 电子邮箱 */
    private String mchtEmail;
    /** 座机电话号码，格式：区号-号码 */
    private String telephone;
    /** 联系人姓名 */
    private String mchtPersonName;
    /** 商户手机号，不同商户联系人手机不能重复 */
    private String mchtPhone;
    /** 法定代表人姓名 */
    private String mchtArtifName;
    /** 法定代表人证件号 */
    private String mchtArtifId;
    /**法定代表人证件生效日期，YYYY-MM-DD */
    private String artifSdate;
    /** 法定代表人证件失效日期，YYYY-MM-DD */
    private String artifEdate;
    /** 营业执照类别：1、三证合一 2、非三证合一，必填 */
    private String mchtLicnType;
    /** 营业执照编号，必填 */
    private String mchtLicnNo;
    /** 营业执照生效日期，YYYY-MM-DD */
    private String mchtLicnSdate;
    /** 营业执照失效日期，YYYY-MM-DD */
    private String mchtLicnEdate;
    /** 组织机构代码证件号 */
    private String occNo;
    /** 组织机构代码证生效日期，YYYY-MM-DD */
    private String occSdate;
    /** 组织机构代码证失效日期，YYYY-MM-DD */
    private String occEdate;
    /** 税务登记证号 */
    private String trcNo;
    /** 税务登记证生效日期，YYYY-MM-DD */
    private String trcSdate;
    /** 税务登记证失效日期，YYYY-MM-DD */
    private String trcEdate;
    /** 业务类型 */
    private List<MerchantService> serviceList;
    /** 清算方式：01-清算到本商户 02-清算到上级商户 03-清算到本商户。有上级商户时，备选02、03，无上级商户，默认为01，不提供选择 */
    private String setlType;
    /** 结算账户类型：1对公 2对私，个体工商户只能对私 */
    private String setlAcctType;
    /** 结算账户人身份：1法定代表人 2法定代表人亲属，结算账户类型对公时无效，对私必填 */
    private String accountBoss;
    /** 法定代表人亲属证件号码 */
    // private String accountIdNo;
    /** 结算账户户名 */
    private String setlAcctName;
    /** 结算账户账号 */
    private String setlAcctNo;
    /** 开户银行编号 */
    private String setlBankCode;
    /** 结算账户证件号 */
    private String setlAccIdNo;
    /** 开户支行编号 */
    private String setlSubBranchCode;
    /** 银行预留手机号，对公账户可以不上送，对私必填 */
    private String setlBankPhone;
    /** 图片列表 */
    private List<MerchantPicturUrl> mchtPicUrlList;

    public String getQrTokenCode() {
        return qrTokenCode;
    }

    public void setQrTokenCode(String qrTokenCode) {
        this.qrTokenCode = qrTokenCode;
    }

    public String getMchtMngNo() {
        return mchtMngNo;
    }

    public void setMchtMngNo(String mchtMngNo) {
        this.mchtMngNo = mchtMngNo;
    }

    public String getMchtType() {
        return mchtType;
    }

    public void setMchtType(String mchtType) {
        this.mchtType = mchtType;
    }

    public String getFirCateCode() {
        return firCateCode;
    }

    public void setFirCateCode(String firCateCode) {
        this.firCateCode = firCateCode;
    }

    public String getSecCateCode() {
        return secCateCode;
    }

    public void setSecCateCode(String secCateCode) {
        this.secCateCode = secCateCode;
    }

    public String getThdCateCode() {
        return thdCateCode;
    }

    public void setThdCateCode(String thdCateCode) {
        this.thdCateCode = thdCateCode;
    }

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getMchtName() {
        return mchtName;
    }

    public void setMchtName(String mchtName) {
        this.mchtName = mchtName;
    }

    public String getMchtSimpleName() {
        return mchtSimpleName;
    }

    public void setMchtSimpleName(String mchtSimpleName) {
        this.mchtSimpleName = mchtSimpleName;
    }

    public String getMchtContAddr() {
        return mchtContAddr;
    }

    public void setMchtContAddr(String mchtContAddr) {
        this.mchtContAddr = mchtContAddr;
    }

    public String getMchtEmail() {
        return mchtEmail;
    }

    public void setMchtEmail(String mchtEmail) {
        this.mchtEmail = mchtEmail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMchtPersonName() {
        return mchtPersonName;
    }

    public void setMchtPersonName(String mchtPersonName) {
        this.mchtPersonName = mchtPersonName;
    }

    public String getMchtPhone() {
        return mchtPhone;
    }

    public void setMchtPhone(String mchtPhone) {
        this.mchtPhone = mchtPhone;
    }

    public String getMchtArtifName() {
        return mchtArtifName;
    }

    public void setMchtArtifName(String mchtArtifName) {
        this.mchtArtifName = mchtArtifName;
    }

    public String getMchtArtifId() {
        return mchtArtifId;
    }

    public void setMchtArtifId(String mchtArtifId) {
        this.mchtArtifId = mchtArtifId;
    }

    public String getArtifSdate() {
        return artifSdate;
    }

    public void setArtifSdate(String artifSdate) {
        this.artifSdate = artifSdate;
    }

    public String getArtifEdate() {
        return artifEdate;
    }

    public void setArtifEdate(String artifEdate) {
        this.artifEdate = artifEdate;
    }

    public String getMchtLicnType() {
        return mchtLicnType;
    }

    public void setMchtLicnType(String mchtLicnType) {
        this.mchtLicnType = mchtLicnType;
    }

    public String getMchtLicnNo() {
        return mchtLicnNo;
    }

    public void setMchtLicnNo(String mchtLicnNo) {
        this.mchtLicnNo = mchtLicnNo;
    }

    public String getMchtLicnSdate() {
        return mchtLicnSdate;
    }

    public void setMchtLicnSdate(String mchtLicnSdate) {
        this.mchtLicnSdate = mchtLicnSdate;
    }

    public String getMchtLicnEdate() {
        return mchtLicnEdate;
    }

    public void setMchtLicnEdate(String mchtLicnEdate) {
        this.mchtLicnEdate = mchtLicnEdate;
    }

    public String getOccNo() {
        return occNo;
    }

    public void setOccNo(String occNo) {
        this.occNo = occNo;
    }

    public String getOccSdate() {
        return occSdate;
    }

    public void setOccSdate(String occSdate) {
        this.occSdate = occSdate;
    }

    public String getOccEdate() {
        return occEdate;
    }

    public void setOccEdate(String occEdate) {
        this.occEdate = occEdate;
    }

    public String getTrcNo() {
        return trcNo;
    }

    public void setTrcNo(String trcNo) {
        this.trcNo = trcNo;
    }

    public String getTrcSdate() {
        return trcSdate;
    }

    public void setTrcSdate(String trcSdate) {
        this.trcSdate = trcSdate;
    }

    public String getTrcEdate() {
        return trcEdate;
    }

    public void setTrcEdate(String trcEdate) {
        this.trcEdate = trcEdate;
    }

     public List<MerchantService> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<MerchantService> serviceList) {
        this.serviceList = serviceList;
    }

    public String getSetlType() {
        return setlType;
    }

    public void setSetlType(String setlType) {
        this.setlType = setlType;
    }

    public String getSetlAcctType() {
        return setlAcctType;
    }

    public void setSetlAcctType(String setlAcctType) {
        this.setlAcctType = setlAcctType;
    }

    public String getAccountBoss() {
        return accountBoss;
    }

    public void setAccountBoss(String accountBoss) {
        this.accountBoss = accountBoss;
    }

/*    public String getAccountIdNo() {
        return accountIdNo;
    }

    public void setAccountIdNo(String accountIdNo) {
        this.accountIdNo = accountIdNo;
    }*/

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

    public String getSetlBankCode() {
        return setlBankCode;
    }

    public void setSetlBankCode(String setlBankCode) {
        this.setlBankCode = setlBankCode;
    }

    public String getSetlAccIdNo() {
        return setlAccIdNo;
    }

    public void setSetlAccIdNo(String setlAccIdNo) {
        this.setlAccIdNo = setlAccIdNo;
    }

    public String getSetlSubBranchCode() {
        return setlSubBranchCode;
    }

    public void setSetlSubBranchCode(String setlSubBranchCode) {
        this.setlSubBranchCode = setlSubBranchCode;
    }

    public String getSetlBankPhone() {
        return setlBankPhone;
    }

    public void setSetlBankPhone(String setlBankPhone) {
        this.setlBankPhone = setlBankPhone;
    }

    public List<MerchantPicturUrl> getMchtPicUrlList() {
        return mchtPicUrlList;
    }

    public void setMchtPicUrlList(List<MerchantPicturUrl> mchtPicUrlList) {
        this.mchtPicUrlList = mchtPicUrlList;
    }

    public static class MerchantService{
        private int serviceID;
        private double rate;

        public int getServiceID() {
            return serviceID;
        }

        public double getRate() {
            return rate;
        }

        public MerchantService(int serviceID, double rate){
            this.serviceID = serviceID;
            this.rate = rate;
        }
    }

    public static class MerchantPicturUrl{
        private String mchtPicType;
        private String mchtPicUrl;

        public String getMchtPicType() {
            return mchtPicType;
        }

        public String getMchtPicUrl() {
            return mchtPicUrl;
        }

        public MerchantPicturUrl(String type, String Url){
            this.mchtPicType = type;
            this.mchtPicUrl = Url;
        }
    }

    public static void main(String[] args) {

        PostMerchantsRequest req = new PostMerchantsRequest();
        req.setSetlType("01");
        req.setSetlAcctName("金贝贝");

        final MerchantService service = new PostMerchantsRequest.MerchantService(1, 26);

        List<MerchantService> services = new ArrayList<MerchantService>();
        services.add(service);
        req.setServiceList(services);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(req);
            System.out.println(jsonString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
