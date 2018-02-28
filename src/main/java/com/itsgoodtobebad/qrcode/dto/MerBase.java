package com.itsgoodtobebad.qrcode.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liliangxi.
 *         Created on 2018/2/23.
 */
public class MerBase {
    /** 商户内部id，格式：代理商邀请码+19位数字(SnowflakeIdWorker) */
    private String id;
    /** 正式商户号，二维码支付平台返回 */
    private String mchtid;
    /** 代理商Id */
    private String agentid;
    /** 上级商户号 */
    private String mchtmngno;
    /** 二维码，预先分配二维码牌的商户必填 */
    private String qrtokencode;
    /** 商户类型 01企业法人 02政府机构（暂不支持） 03事业单位（暂不支持） 04个体工商 */
    private String mchttype;
    /** 一级行业编号 */
    private String fircatecode;
    /** 二级行业编号 */
    private String seccatecode;
    /** 三级行业编号 */
    private String thdcatecode;
    /** 所属城市编号 */
    private String addresscode;
    /** 商户名称 */
    private String mchtname;
    /** 商户简称 */
    private String mchtsimplename;
    /** 经营地址 */
    private String mchtcontaddr;
    /** 电子邮箱 */
    private String mchtemail;
    /** 座机电话号码，格式：区号-号码 */
    private String telephone;
    /** 联系人姓名 */
    private String mchtpersonname;
    /** 商户手机号，不同商户联系人手机不能重复 */
    private String mchtphone;
    /** 法定代表人姓名 */
    private String mchtartifname;
    /** 法人性别，1男 2女 */
    private String mchtartifsex;
    /** 法定代表人证件号 */
    private String mchtartifid;
    /**法定代表人证件生效日期，YYYY-MM-DD */
    private String artifsdate;
    /** 法定代表人证件失效日期，YYYY-MM-DD */
    private String artifedate;
    /** 法定代表人证件国别/地区， 中国CHN 香港HKG 澳门MAC 台湾CTN，默认CHN */
    private String mchtartifcountryid;
    /** 法定代表人职业 */
    private String mchtartifjob;
    /** 法定代表人住址 */
    private String mchtaritfaddress;
    /** 营业执照类别：1、三证合一 2、非三证合一，必填 */
    private String mchtlicntype;
    /** 营业执照编号，企业法人和个体工商户必填 */
    private String mchtlicnno;
    /** 营业执照生效日期，YYYY-MM-DD */
    private String mchtlicnsdate;
    /** 营业执照失效日期，YYYY-MM-DD */
    private String mchtlicnedate;
    /** 组织机构代码证件号 */
    private String occno;
    /** 组织机构代码证生效日期，YYYY-MM-DD */
    private String occsdate;
    /** 组织机构代码证失效日期，YYYY-MM-DD */
    private String occedate;
    /** 税务登记证号 */
    private String trcno;
    /** 税务登记证生效日期，YYYY-MM-DD */
    private String trcsdate;
    /** 税务登记证失效日期，YYYY-MM-DD */
    private String trcedate;
    /** 产品及费率配置列表 */
    private String prodandratelist;
    //private List<ProdAndRate> prodandratelist;
    /** 业务类型 */
    //private List<MerchantService> servicelist;
    private String servicelist;
    /** 清算方式：01-清算到本商户 02-清算到上级商户 03-清算到本商户。有上级商户时，备选02、03，无上级商户，默认为01，不提供选择 */
    private String setltype;
    /** 清算标识 01工作日结算 02自然日结算 */
    private String setlsymbol;
    /** 信用卡限制标志 00可用信用卡 01禁用信用卡 */
    private String creditlimit;
    /** 结算周期，取值1～365，代表T+1～T+365 */
    private String specsetlday;
    /** 结算账户类型：1对公 2对私，个体工商户只能对私 */
    private String setlaccttype;
    /** 结算账户人身份：1法定代表人 2法定代表人亲属，结算账户类型对公时无效，对私必填 */
    private String accountboss;
    /** 结算账户证件种类 10对私支持身份证 16对公支持营业执照 */
    private String setlacctidtype;
    /** 结算账户证件号码 */
    private String setlacctidno;
    /** 结算账户户名 */
    private String setlacctname;
    /** 结算账户号 */
    private String setlacctno;
    /** 结算账户开户银行编号 */
    private String setlacctbankno;
    /** 结算账户开户支行编号 */
    private String setlacctbranchno;

    /** 银行预留手机号，对公账户可以不上送，对私必填 */
    private String setlbankphone;
    /** 财务联系人 */
    private String financialcontact;
    /** 财务联系电话 */
    private String financialel;
    /** 图片列表 */
    //private List<MerchantPicturUrl> mchtpicurllist;
    /** 商户状态 00_正常，01_冻结，02_注销，98_入网中 */
    private String status;
    private String approvestatus;
    private String auditdesc;
    private String faildesc;
    private String employeeid;
    private int approvalid;
    private Date accessdate;
    private String intro;
    private String remark;
    private String subscriptio;
    private String openid;
    private String authdirectory;
    private String mchtcertid;
    private Date createtime;
    private Date updatetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMchtid() {
        return mchtid;
    }

    public void setMchtid(String mchtid) {
        this.mchtid = mchtid;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getMchtmngno() {
        return mchtmngno;
    }

    public void setMchtmngno(String mchtmngno) {
        this.mchtmngno = mchtmngno;
    }

    public String getQrtokencode() {
        return qrtokencode;
    }

    public void setQrtokencode(String qrtokencode) {
        this.qrtokencode = qrtokencode;
    }

    public String getMchttype() {
        return mchttype;
    }

    public void setMchttype(String mchttype) {
        this.mchttype = mchttype;
    }

    public String getFircatecode() {
        return fircatecode;
    }

    public void setFircatecode(String fircatecode) {
        this.fircatecode = fircatecode;
    }

    public String getSeccatecode() {
        return seccatecode;
    }

    public void setSeccatecode(String seccatecode) {
        this.seccatecode = seccatecode;
    }

    public String getThdcatecode() {
        return thdcatecode;
    }

    public void setThdcatecode(String thdcatecode) {
        this.thdcatecode = thdcatecode;
    }

    public String getAddresscode() {
        return addresscode;
    }

    public void setAddresscode(String addresscode) {
        this.addresscode = addresscode;
    }

    public String getMchtname() {
        return mchtname;
    }

    public void setMchtname(String mchtname) {
        this.mchtname = mchtname;
    }

    public String getMchtsimplename() {
        return mchtsimplename;
    }

    public void setMchtsimplename(String mchtsimplename) {
        this.mchtsimplename = mchtsimplename;
    }

    public String getMchtcontaddr() {
        return mchtcontaddr;
    }

    public void setMchtcontaddr(String mchtcontaddr) {
        this.mchtcontaddr = mchtcontaddr;
    }

    public String getMchtemail() {
        return mchtemail;
    }

    public void setMchtemail(String mchtemail) {
        this.mchtemail = mchtemail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMchtpersonname() {
        return mchtpersonname;
    }

    public void setMchtpersonname(String mchtpersonname) {
        this.mchtpersonname = mchtpersonname;
    }

    public String getMchtphone() {
        return mchtphone;
    }

    public void setMchtphone(String mchtphone) {
        this.mchtphone = mchtphone;
    }

    public String getMchtartifname() {
        return mchtartifname;
    }

    public void setMchtartifname(String mchtartifname) {
        this.mchtartifname = mchtartifname;
    }

    public String getMchtartifsex() {
        return mchtartifsex;
    }

    public void setMchtartifsex(String mchtartifsex) {
        this.mchtartifsex = mchtartifsex;
    }

    public String getMchtartifid() {
        return mchtartifid;
    }

    public void setMchtartifid(String mchtartifid) {
        this.mchtartifid = mchtartifid;
    }

    public String getArtifsdate() {
        return artifsdate;
    }

    public void setArtifsdate(String artifsdate) {
        this.artifsdate = artifsdate;
    }

    public String getArtifedate() {
        return artifedate;
    }

    public void setArtifedate(String artifedate) {
        this.artifedate = artifedate;
    }

    public String getMchtartifcountryid() {
        return mchtartifcountryid;
    }

    public void setMchtartifcountryid(String mchtartifcountryid) {
        this.mchtartifcountryid = mchtartifcountryid;
    }

    public String getMchtartifjob() {
        return mchtartifjob;
    }

    public void setMchtartifjob(String mchtartifjob) {
        this.mchtartifjob = mchtartifjob;
    }

    public String getMchtaritfaddress() {
        return mchtaritfaddress;
    }

    public void setMchtaritfaddress(String mchtaritfaddress) {
        this.mchtaritfaddress = mchtaritfaddress;
    }

    public String getMchtlicntype() {
        return mchtlicntype;
    }

    public void setMchtlicntype(String mchtlicntype) {
        this.mchtlicntype = mchtlicntype;
    }

    public String getMchtlicnno() {
        return mchtlicnno;
    }

    public void setMchtlicnno(String mchtlicnno) {
        this.mchtlicnno = mchtlicnno;
    }

    public String getMchtlicnsdate() {
        return mchtlicnsdate;
    }

    public void setMchtlicnsdate(String mchtlicnsdate) {
        this.mchtlicnsdate = mchtlicnsdate;
    }

    public String getMchtlicnedate() {
        return mchtlicnedate;
    }

    public void setMchtlicnedate(String mchtlicnedate) {
        this.mchtlicnedate = mchtlicnedate;
    }

    public String getOccno() {
        return occno;
    }

    public void setOccno(String occno) {
        this.occno = occno;
    }

    public String getOccsdate() {
        return occsdate;
    }

    public void setOccsdate(String occsdate) {
        this.occsdate = occsdate;
    }

    public String getOccedate() {
        return occedate;
    }

    public void setOccedate(String occedate) {
        this.occedate = occedate;
    }

    public String getTrcno() {
        return trcno;
    }

    public void setTrcno(String trcno) {
        this.trcno = trcno;
    }

    public String getTrcsdate() {
        return trcsdate;
    }

    public void setTrcsdate(String trcsdate) {
        this.trcsdate = trcsdate;
    }

    public String getTrcedate() {
        return trcedate;
    }

    public void setTrcedate(String trcedate) {
        this.trcedate = trcedate;
    }

    public String getProdandratelist() {
        return prodandratelist;
    }

    public void setProdandratelist(String prodandratelist) {
        this.prodandratelist = prodandratelist;
    }

    public String getServicelist() {
        return servicelist;
    }

    public void setServicelist(String servicelist) {
        this.servicelist = servicelist;
    }

    public String getSetltype() {
        return setltype;
    }

    public void setSetltype(String setltype) {
        this.setltype = setltype;
    }

    public String getSetlsymbol() {
        return setlsymbol;
    }

    public void setSetlsymbol(String setlsymbol) {
        this.setlsymbol = setlsymbol;
    }

    public String getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(String creditlimit) {
        this.creditlimit = creditlimit;
    }

    public String getSpecsetlday() {
        return specsetlday;
    }

    public void setSpecsetlday(String specsetlday) {
        this.specsetlday = specsetlday;
    }

    public String getSetlaccttype() {
        return setlaccttype;
    }

    public void setSetlaccttype(String setlaccttype) {
        this.setlaccttype = setlaccttype;
    }

    public String getAccountboss() {
        return accountboss;
    }

    public void setAccountboss(String accountboss) {
        this.accountboss = accountboss;
    }

    public String getSetlacctidtype() {
        return setlacctidtype;
    }

    public void setSetlacctidtype(String setlacctidtype) {
        this.setlacctidtype = setlacctidtype;
    }

    public String getSetlacctidno() {
        return setlacctidno;
    }

    public void setSetlacctidno(String setlacctidno) {
        this.setlacctidno = setlacctidno;
    }

    public String getSetlacctname() {
        return setlacctname;
    }

    public void setSetlacctname(String setlacctname) {
        this.setlacctname = setlacctname;
    }

    public String getSetlacctno() {
        return setlacctno;
    }

    public void setSetlacctno(String setlacctno) {
        this.setlacctno = setlacctno;
    }

    public String getSetlacctbankno() {
        return setlacctbankno;
    }

    public void setSetlacctbankno(String setlacctbankno) {
        this.setlacctbankno = setlacctbankno;
    }

    public String getSetlacctbranchno() {
        return setlacctbranchno;
    }

    public void setSetlacctbranchno(String setlacctbranchno) {
        this.setlacctbranchno = setlacctbranchno;
    }

    public String getSetlbankphone() {
        return setlbankphone;
    }

    public void setSetlbankphone(String setlbankphone) {
        this.setlbankphone = setlbankphone;
    }

    public String getFinancialcontact() {
        return financialcontact;
    }

    public void setFinancialcontact(String financialcontact) {
        this.financialcontact = financialcontact;
    }

    public String getFinancialel() {
        return financialel;
    }

    public void setFinancialel(String financialel) {
        this.financialel = financialel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovestatus() {
        return approvestatus;
    }

    public void setApprovestatus(String approvestatus) {
        this.approvestatus = approvestatus;
    }

    public String getAuditdesc() {
        return auditdesc;
    }

    public void setAuditdesc(String auditdesc) {
        this.auditdesc = auditdesc;
    }

    public String getFaildesc() {
        return faildesc;
    }

    public void setFaildesc(String faildesc) {
        this.faildesc = faildesc;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public int getApprovalid() {
        return approvalid;
    }

    public void setApprovalid(int approvalid) {
        this.approvalid = approvalid;
    }

    public Date getAccessdate() {
        return accessdate;
    }

    public void setAccessdate(Date accessdate) {
        this.accessdate = accessdate;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSubscriptio() {
        return subscriptio;
    }

    public void setSubscriptio(String subscriptio) {
        this.subscriptio = subscriptio;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAuthdirectory() {
        return authdirectory;
    }

    public void setAuthdirectory(String authdirectory) {
        this.authdirectory = authdirectory;
    }

    public String getMchtcertid() {
        return mchtcertid;
    }

    public void setMchtcertid(String mchtcertid) {
        this.mchtcertid = mchtcertid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public static class ProdAndRate{
        private String prodId;
        private String prodName;
        private String acctTypeCode;
        private String acctTypeName;
        private String rateId;
        private String rateName;
        private String rateValue;

        public String getProdId() {
            return prodId;
        }

        public String getProdName() {
            return prodName;
        }

        public String getAcctTypeCode() {
            return acctTypeCode;
        }

        public String getAcctTypeName() {
            return acctTypeName;
        }

        public String getRateId() {
            return rateId;
        }

        public String getRateName() {
            return rateName;
        }

        public String getRateValue() {
            return rateValue;
        }
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

    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
