package com.itsgoodtobebad.qrcode.testcase;

import com.itsgoodtobebad.qrcode.filter.SetTimeStampAndSignFilter;
import com.itsgoodtobebad.qrcode.request.PostFileRequest;
import com.itsgoodtobebad.qrcode.request.PostMerchantsRequest;
import com.itsgoodtobebad.qrcode.utils.BusinessLicenseUtils;
import com.itsgoodtobebad.qrcode.utils.DateTimeUtils;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import java.io.File;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author liliangxi.
 *         Created on 2018/1/17.
 */
public class RegisterMerchantTest extends BasicTest{

    private PostMerchantsRequest.MerchantPicturUrl uploadPicture(String picType, String fileName){
        PostFileRequest req = new PostFileRequest();
        File file = new File("src/test/resources/Koala.jpg");
        req.headers.put("Content-Type", "multipart/form-data");

        String fileNo =
        given().headers(req.headers)
                .port(7506)
                .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                .multiPart(file)
                .when()
                .post(req.getUri())
                .then().extract().path("content.fileName");

        PostMerchantsRequest.MerchantPicturUrl pic = new PostMerchantsRequest.MerchantPicturUrl(picType, fileNo);

        return pic;
    }

    private void InitMerchantBasicInfo(PostMerchantsRequest req){
        req.setMchtType("01");                                  // 商户类型：01企业法人 04个体工商
        req.setFirCateCode("30000");                            // 一级行业编号
        req.setSecCateCode("31100");                            // 二级行业编号
        req.setThdCateCode("31108");                            // 三级行业编号
        req.setAddressCode("110101");                           // 所属城市编号
        req.setMchtName("接口进件商户" + DateTimeUtils.getTimestamp("yyyyMMddHHmmss"));                        // 商户名称
        req.setMchtSimpleName("进商");                          // 商户简称
        req.setMchtContAddr("重庆市北部新区星光五路3号");       // 经营地址
        req.setMchtEmail("10@263.com");                            // 联系人邮箱
        req.setMchtPersonName("小丹尼");                        // 联系人姓名
        req.setMchtLicnType("01");                              // 营业执照类别：01三证合一 02非三证合一
        req.setMchtLicnNo("9999" + DateTimeUtils.getTimestamp("yyyyMMddHHmmss"));                  // 营业执照编号

        /** 业务列表
         * 业务类型：1-固定二维码牌 2-扫码枪 3-线上二维码
         * 费率，单位‰ ，取值0.0-99.9
         */
        req.setServiceList(new ArrayList<PostMerchantsRequest.MerchantService>(){{
            add(new PostMerchantsRequest.MerchantService(1, 2.6));
            add(new PostMerchantsRequest.MerchantService(2, 2.6));
            add(new PostMerchantsRequest.MerchantService(3, 2.6));
        }});

        req.setSetlType("01");                                  // 清算方式：01清算到本商户 02清算到上级商户 03清算到本商户（有上级商户才能选择02/03）
        req.setSetlAcctType("1");                               // 结算账户类型 1对公 2对私（个体工商只能选择对私）
        req.setSetlAcctName("金贝贝");                          // 结算账户户名
        req.setSetlAcctNo("20-123456789012345");                // 结算账户账号
        req.setSetlBankCode("102");                             // 开户银行编号
        req.setSetlSubBranchCode("102121000447");               // 开户支行编号

        /** 图片列表
         * 图片类型：
         * 01-营业执照照片
         * 02-法定代表人证件正面
         * 07-法定代表人证件反面
         * 09-店铺门头照(含有招牌)
         * 13-开户许可证
         * 图片编号：文件上传接口上传成功后返回的编号
         * */
        req.setMchtPicUrlList(new ArrayList<PostMerchantsRequest.MerchantPicturUrl>(){{
            add(new PostMerchantsRequest.MerchantPicturUrl("01", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("02", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("07", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("09", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("13", "5cdfaff9885c4629b18873e9a745d19f"));
        }});
    }

    @Test
    public void test(){
        uploadPicture("02", "");

    }

    /** 企业商户+三证合一+对公账户收款 */
    @Test
    public void RegisterMerchantTest_Enterprise_CompanyAccount(){
        PostMerchantsRequest req = new PostMerchantsRequest();
        InitMerchantBasicInfo(req);

        req.setMchtPhone("14400000016");

        ValidatableResponse response =
                given().headers(req.headers)
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .body(req)
                        .log().all()
                        .when()
                        .post(req.getUri())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("code", equalTo("0000"));

    }

    /** 企业商户+非三证合一+法定代表人收款 */
    @Test
    public void RegisterMerchantTest_Enterprise_LegalRepresentative(){
        PostMerchantsRequest req = new PostMerchantsRequest();
        InitMerchantBasicInfo(req);

        req.setMchtLicnType("2");
        req.setSetlAcctType("2");
        req.setAccountBoss("1");
        req.setMchtPhone("14426262626");

        /** 图片列表
         * 图片类型：
         * 01-营业执照照片
         * 02-法定代表人证件正面
         * 07-法定代表人证件反面
         * 08-银行卡正面照(收款人银行卡照片)
         * 09-店铺门头照(含有招牌)
         * 图片编号：文件上传接口上传成功后返回的编号
         * */
        req.setMchtPicUrlList(new ArrayList<PostMerchantsRequest.MerchantPicturUrl>(){{
            add(new PostMerchantsRequest.MerchantPicturUrl("01", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("02", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("07", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("08", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("09", "5cdfaff9885c4629b18873e9a745d19f"));
        }});

        ValidatableResponse response =
                given().headers(req.headers)
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .body(req)
                        .log().all()
                        .when()
                        .post(req.getUri())
                        .then()
                        .log().all()
                        .body("code", equalTo("0000"));

    }

    /** 企业商户+非三证合一+法定代表人亲属收款 */
    @Test
    public void RegisterMerchantTest_Enterprise_Other(){
        PostMerchantsRequest req = new PostMerchantsRequest();
        InitMerchantBasicInfo(req);

        /** 结算账户类型 1_对公 2_对私 */
        req.setSetlAcctType("2");
        /** 结算账户人身份，1_法人，2_法人亲属 */
        req.setAccountBoss("2");
        /** 法人亲属证件号码 */
        //req.setAccountIdNo("110101198001190015");
        /** 商户手机号，不同商户联系人手机不能重复 */
        req.setMchtPhone("14437272727");
        /** 银行预留手机号，对私必填 */
        req.setSetlBankPhone("14530000001");

        /** 图片列表
         * 图片类型：
         * 01-营业执照照片
         * 02-法定代表人证件正面
         * 07-法定代表人证件反面
         * 08-银行卡正面照(收款人银行卡照片)
         * 09-店铺门头照(含有招牌)
         * 18-收款人证件正面
         * 19-收款人证件反面
         * 23-授权证明(委托收款通知书)
         * 图片编号：文件上传接口上传成功后返回的编号
         * */
        req.setMchtPicUrlList(new ArrayList<PostMerchantsRequest.MerchantPicturUrl>(){{
            add(new PostMerchantsRequest.MerchantPicturUrl("01", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("02", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("07", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("08", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("09", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("18", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("19", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("23", "5cdfaff9885c4629b18873e9a745d19f"));
        }});

        ValidatableResponse response =
                given().headers(req.headers)
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .body(req)
                        .log().all()
                        .when()
                        .post(req.getUri())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("code", equalTo("0000"));

    }

    /** 个体工商户，法定代表人收款 */
    @Test
    public void RegisterMerchantTest_IndividualMerchant_LegalRepresentative(){
        PostMerchantsRequest req = new PostMerchantsRequest();
        InitMerchantBasicInfo(req);
        req.setMchtType("04");                                  // 商户类型：01企业法人 04个体工商
        req.setMchtPhone("14425252526");                        // 联系人手机号
        req.setSetlAcctType("2");                               // 结算账户类型 1对公 2对私（个体工商只能选择对私）
        req.setAccountBoss("1");                                // 结算账户人身份，1_法人，2_法人亲属

        /** 图片列表
         * 图片类型：
         * 01-营业执照照片
         * 02-法定代表人证件正面
         * 07-法定代表人证件反面
         * 08-银行卡正面照(收款人银行卡照片)
         * 09-店铺门头照(含有招牌)
         * 图片编号：文件上传接口上传成功后返回的编号
         * */
        req.setMchtPicUrlList(new ArrayList<PostMerchantsRequest.MerchantPicturUrl>(){{
            add(new PostMerchantsRequest.MerchantPicturUrl("01", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("02", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("07", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("08", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("09", "5cdfaff9885c4629b18873e9a745d19f"));
        }});

        ValidatableResponse response =
                given().headers(req.headers)
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .body(req)
                        .log().all()
                        .when()
                        .post(req.getUri())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("code", equalTo("0000"));

    }

    /** 个体工商户，法定代表人亲属收款 */
    @Test
    public void RegisterMerchantTest_IndividualMerchant_Other(){
        PostMerchantsRequest req = new PostMerchantsRequest();
        InitMerchantBasicInfo(req);

        req.setMchtType("04");                                  // 商户类型：01企业法人 04个体工商
        req.setMchtPhone("19100000011");                        // 联系人手机号
        req.setSetlAcctType("2");                               // 结算账户类型 1对公 2对私（个体工商只能选择对私）
        req.setAccountBoss("2");                                // 结算账户人身份，1_法人，2_法人亲属
        //req.setAccountIdNo("110101198001190074");               // 法人亲属证件号码
        req.setSetlBankPhone("13665252526");                    // 银行预留手机号, 对公账户可以不上送。对私账户必填。

        /** 图片列表
         * 图片类型：
         * 01-营业执照照片
         * 02-法定代表人证件正面
         * 07-法定代表人证件反面
         * 08-银行卡正面照(收款人银行卡照片)
         * 09-店铺门头照(含有招牌)
         * 18-收款人证件正面
         * 19-收款人证件反面
         * 23-授权证明(委托收款通知书)
         * 图片编号：文件上传接口上传成功后返回的编号
         * */
        req.setMchtPicUrlList(new ArrayList<PostMerchantsRequest.MerchantPicturUrl>(){{
            add(new PostMerchantsRequest.MerchantPicturUrl("01", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("02", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("07", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("08", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("09", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("18", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("19", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("23", "5cdfaff9885c4629b18873e9a745d19f"));
        }});

        ValidatableResponse response =
                given().headers(req.headers)
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .body(req)
                        .log().all()
                        .when()
                        .post(req.getUri())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("code", equalTo("0000"));

    }

    /** 全数据测试，个体工商户，法定代表人亲属收款
     * 可选字段均按照最大长度 */
    @Test
    public void RegisterMerchantTest_IndividualMerchant_Other_FullData(){
        PostMerchantsRequest req = new PostMerchantsRequest();
        // req.setQrTokenCode("");                   // 二维码，预先分配二维码牌的商户必填
        req.setMchtMngNo("920180119000001");                             // 上级商户编号
        req.setMchtType("04");                                  // 商户类型：01企业法人 04个体工商
        req.setFirCateCode("30000");                            // 一级行业编号
        req.setSecCateCode("31100");                            // 二级行业编号
        req.setThdCateCode("31108");                            // 三级行业编号
        req.setAddressCode("01234567");                           // 所属城市编号
        req.setMchtName("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");                        // 商户名称
        req.setMchtSimpleName("01234567890123456789012345678901234567890123456789");                          // 商户简称
        req.setMchtContAddr("01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");       // 经营地址
        req.setMchtEmail("01234567890123456789012345678901234567890123456789");                            // 联系人邮箱
        req.setTelephone("01234567890123456789");                       // 座机电话
        req.setMchtPersonName("01234567890123456789012345678901234567890123456789");                        // 联系人姓名
        req.setMchtPhone("99999999999");                        // 联系人手机号

        req.setMchtArtifName("01234567890123456789012345678901234567890123456789");                       // 法定代表人姓名
        req.setMchtArtifId("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");  // 法定代表人证件号
        req.setArtifSdate("2017-01-01");                         // 法定代表人证件生效日期
        req.setArtifEdate("2018-12-12");                         // 法定代表人证件失效日期

        req.setMchtLicnType("01");                               // 营业执照类别：01三证合一 02非三证合一
        req.setMchtLicnNo("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");                  // 营业执照编号
        req.setMchtLicnSdate("2017-01-01");
        req.setMchtLicnEdate("2019-01-01");
        req.setOccNo("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
        req.setOccSdate("2017-01-01");
        req.setOccEdate("2019-01-01");
        req.setTrcNo("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
        req.setTrcSdate("2017-01-01");
        req.setTrcEdate("2019-01-01");


        /** 业务列表
         * 业务类型：1-固定二维码牌 2-扫码枪 3-线上二维码
         * 费率，单位‰ ，取值0.0-99.9
         */
        req.setServiceList(new ArrayList<PostMerchantsRequest.MerchantService>(){{
            add(new PostMerchantsRequest.MerchantService(1, 0));
            add(new PostMerchantsRequest.MerchantService(2, 99.9));
            add(new PostMerchantsRequest.MerchantService(3, 99.9));
        }});
        req.setSetlType("01");                                  // 清算方式：01清算到本商户 02清算到上级商户 03清算到本商户（有上级商户才能选择02/03）

        req.setSetlAcctType("2");                               // 结算账户类型 1对公 2对私（个体工商只能选择对私）
        req.setAccountBoss("2");                                // 结算账户人身份，1_法人，2_法人亲属
        //req.setAccountIdNo("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"); // 法人亲属证件号码，法人亲属必填

        req.setSetlAcctName("01234567890123456789012345678901234567890123456789");                          // 结算账户户名
        req.setSetlAcctNo("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");                // 结算账户账号
        req.setSetlBankCode("01234567890123456789012345678901234567890123456789");                             // 开户银行编号
        req.setSetlSubBranchCode("01234567890123456789012345678901234567890123456789");               // 开户支行编号
        req.setSetlBankPhone("14000000001");


        /** 图片列表
         * 图片类型：
         * 01-营业执照照片
         * 02-法定代表人证件正面
         * 07-法定代表人证件反面
         * 09-店铺门头照(含有招牌)
         * 13-开户许可证
         * 22-商户协议
         * 图片编号：文件上传接口上传成功后返回的编号
         * */
        req.setMchtPicUrlList(new ArrayList<PostMerchantsRequest.MerchantPicturUrl>(){{
            add(new PostMerchantsRequest.MerchantPicturUrl("00", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("01", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("02", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("03", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("04", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("05", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("06", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("07", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("08", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("09", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("10", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("11", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("12", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("13", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("14", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("15", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("16", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("17", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("18", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("19", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("20", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("21", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("22", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("23", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("24", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("25", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("26", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("27", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("28", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("29", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("30", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("31", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("32", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("33", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("34", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("35", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("36", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("37", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("38", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("39", "5cdfaff9885c4629b18873e9a745d19f"));
        }});

        ValidatableResponse response =
                given().headers(req.headers)
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .body(req)
                        .log().all()
                        .when()
                        .post(req.getUri())
                        .then()
                        .log().all()
                        .statusCode(200)
                        .body("code", equalTo("0000"));

    }

    /** 异常测试临时用 */
    @Test
    public void RegisterMerchantTest_Current() throws Exception {
        PostMerchantsRequest req = new PostMerchantsRequest();
        InitMerchantBasicInfo(req);

        req.setMchtPhone("18900000028");                         // 商户手机号，不同商户联系人手机不能重复

        /** 110101 表示北京东城区
         * 21 表示私人 */
        //req.setMchtLicnNo("110101210000001" + BusinessLicenseUtils.getVerifyBit("11010121000001"));

        req.setMchtType("04");

        /** 第一位9表示工商
         * 第2位：1企业 2个体工商户*/
        String pre = "92" + "110101" + "000000012";
        System.out.println(BusinessLicenseUtils.getVerifyBit(pre));
        req.setMchtLicnNo(pre + BusinessLicenseUtils.getVerifyBit(pre));

        req.setMchtLicnType("01");
        req.setSetlAcctType("2");
        req.setAccountBoss("2");
        req.setSetlBankPhone("18600000002");

        req.setMchtArtifName("金贝贝");
        req.setMchtArtifId("110101198001260335");
        req.setArtifSdate("2017-01-01");
        req.setArtifEdate("2019-01-01");
        req.setMchtLicnSdate("2017-01-01");
        req.setMchtLicnEdate("2019-01-01");


        req.setMchtPicUrlList(new ArrayList<PostMerchantsRequest.MerchantPicturUrl>(){{
            add(new PostMerchantsRequest.MerchantPicturUrl("01", "2d60a8996e22454cae1c876039b03596"));
            add(new PostMerchantsRequest.MerchantPicturUrl("02", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("07", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("08", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("09", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("18", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("19", "5cdfaff9885c4629b18873e9a745d19f"));
            add(new PostMerchantsRequest.MerchantPicturUrl("23", "5cdfaff9885c4629b18873e9a745d19f"));
        }});

        // --------特定--------
/*        req.setMchtMngNo("920180201000239");
        req.setSetlType("03");*/
        //req.setQrTokenCode("503608765308800330");
        req.setMchtLicnNo("695315020332836121");

        ValidatableResponse response =
                given().headers(req.headers)
                        .filter(new SetTimeStampAndSignFilter(req.appKey, req.appSecret))
                        .body(req)
                        .log().all()
                        .when()
                        .post(req.getUri())
                        .then()
                        .log().all()
                        .body("code", equalTo("0000"));

    }



}
