package com.itsgoodtobebad.qrcode.request;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liliangxi.
 *         Created on 2018/1/15.
 */
public class PutMerchants extends BasicRequest{
    private String mchtId;
    private int opType;
    private String qrTokenCode;
    private String mchtMngNo;
    private String mchtType;
    private String firCateCode;
    private String secCateCode;
    private String thdCateCode;
    private String addressCode;
    private String mchtName;
    private String mchtSimpleName;
    private String mchtContAddr;
    private String mchtEmail;
    private String telephone;
    private String mchtPersonName;
    private String mchtPhone;
    /** 法定代表人姓名 */
    private String mchtArtifName;
    /** 法定代表人证件号 */
    private String mchtArtfId;
    /**法定代表人证件生效日期，YYYY-MM-DD */
    private String artifSdate;
    /** 法定代表人证件失效日期，YYYY-MM-DD */
    private String artifEdate;
    /** 营业执照类别：1、三证合一 2、非三证合一，必填 */
    private String mchtLicnType;
    /** 营业执照编号，必填 */
    private String mchtLicnNo;
    /** 营业执照生效日期，YYYY-MM-DD，必填 */
    private String mchtLicnSdate;
    /** 营业执照失效日期，YYYY-MM-DD，必填 */
    private String mchtLicnEdate;
    /** 组织机构代码证件号，营业执照类型为非三证合一时，企业必填，个体非必填 */
    private String occNo;
    /** 组织机构代码证生效日期，YYYY-MM-DD */
    private String occSdate;
    /** 组织机构代码证失效日期，YYYY-MM-DD */
    private String occEdate;
    /** 税务登记证号，营业执照类型为非三证合一时必填 */
    private String trcNo;
    /** 税务登记证生效日期，YYYY-MM-DD */
    private String trcSdate;
    /** 税务登记证失效日期，YYYY-MM-DD */
    private String trcEdate;
    /** 产品及费率配置列表 */
    private List<ProductAndRate> prodAndRateIList = new ArrayList<ProductAndRate>();
    /** 业务类型 */
    private List<MerchantService> serviceList = new ArrayList<MerchantService>();
    /** 清算方式：01-清算到本商户 02-清算到上级商户 03-清算到本商户。有上级商户时，备选02、03，无上级商户，默认为01，不提供选择 */
    private String setlType = "01";
    /** 清算标识 01-工作日入账 02-自然日入账 */
    private String setlSymbol;
    /** 结算周期，该数值为1~365，代表T+1~T+365 */
    private String specSetlDay;
    private String setlAcctType;
    private String accountBoss;
    private String accountIdNo;
    private String setlAcctName;
    private String setlAcctNo;
    private String setlBankCode;
    private String setlSubBranchCode;
    private String setlBankPhone;
    /** 图片列表 */
    private List<MerchantPicturUrl> mchtPicUrlList = new ArrayList<MerchantPicturUrl>();

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

    public String getMchtArtfId() {
        return mchtArtfId;
    }

    public void setMchtArtfId(String mchtArtfId) {
        this.mchtArtfId = mchtArtfId;
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

    public List<ProductAndRate> getProdAndRateIList() {
        return prodAndRateIList;
    }

    public void setProdAndRateIList(List<ProductAndRate> prodAndRateIList) {
        this.prodAndRateIList = prodAndRateIList;
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

    public String getSetlSymbol() {
        return setlSymbol;
    }

    public void setSetlSymbol(String setlSymbol) {
        this.setlSymbol = setlSymbol;
    }

    public String getSpecSetlDay() {
        return specSetlDay;
    }

    public void setSpecSetlDay(String specSetlDay) {
        this.specSetlDay = specSetlDay;
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

    public String getAccountIdNo() {
        return accountIdNo;
    }

    public void setAccountIdNo(String accountIdNo) {
        this.accountIdNo = accountIdNo;
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

    public String getSetlBankCode() {
        return setlBankCode;
    }

    public void setSetlBankCode(String setlBankCode) {
        this.setlBankCode = setlBankCode;
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

    private static class ProductAndRate{
        /** 产品ID */
        private String prodId;
        /** 账号类型 */
        private String acctTypeCode;
        /** 费率编号 */
        private String rateId;
    }

    private static class MerchantService{
        private int serviceID;
        private float rate;

    }

    private static class MerchantPicturUrl{
        private String mchtPicType;
        private String mchtPicUrl;
    }
}
