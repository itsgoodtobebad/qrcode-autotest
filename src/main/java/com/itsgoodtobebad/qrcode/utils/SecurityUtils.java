package com.itsgoodtobebad.qrcode.utils;

import ocx.Rijndael;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Liliangxi on 2017/6/9.
 */
public class SecurityUtils {
    ///////////////////////////HmacMD5///////////////////////////////
    /**
     * HmacMD5消息摘要
     * @param strData 待做摘要处理的数据
     * @param strKey 密钥
     * @return  String
     */
    public static String encodeHmacMD5(String strData,String strKey) throws Exception {
        //执行消息摘要处理
        byte[] data = strData.getBytes("UTF-8");
        byte[] key = strKey.getBytes("UTF-8");
        //还原密钥，因为密钥是以byte形式为消息传递算法所拥有
        SecretKey secretKey=new SecretKeySpec(key,"HmacMD5");
        //实例化Mac
        Mac mac=Mac.getInstance(secretKey.getAlgorithm());
        //初始化Mac
        mac.init(secretKey);
        //执行消息摘要处理
        byte[] b = mac.doFinal(data);
        //做十六进制转换
        return StringUtils.bytesToHexString(b);
    }

    /**
     * 手机钱包计算消息头sign
     * */
    public static String calcSign(String timestamp, String appkey, String appsecret, String data){
        String calcSign = null;
        if(null == data){
            data = "";
        }

        try {
            calcSign = SecurityUtils.encodeHmacMD5(timestamp + appkey + data, appsecret);
        }catch (Exception e){
            e.printStackTrace();
        }
        return calcSign;
    }

    public static String calcSign(String timestamp, String appkey, String appsecret){
        return calcSign(timestamp, appkey, appsecret, "");
    }

    /**
     * 中兴付App访问AppServer时登录密码和支付密码的加密方法
     * @param key 通过getRandomKey获取的随机密钥
     * @param data 需要加密的原始数据
     * @return 加密后的密文，为了省事，如果加密失败则返回空字符串
     */
    public static String DecryptPassword(String key, String data){
        String saltKey = "90E5975D9435475fB951F814E7511FAC";
        try {
            Base64 ex = new Base64();  // 强烈注意，这里要使用org.apache.commons.codec.binary.Base64，不能使用com.zte.utils里的Base64
            Rijndael aes256 = new Rijndael();
            aes256.makeKey(saltKey.getBytes(), saltKey.length() * 8);
            byte[] tmp = aes256.decryptArrayNP(key.getBytes(), 0);
            byte[] realKey = new byte[32];
            System.arraycopy(ex.encode(tmp), 0, realKey, 0, 32);
            aes256.makeKey(realKey, realKey.length * 8);

            byte[] bytes1 = aes256.encryptArrayNP(data.getBytes(),0);
            byte[] resultBytes = ex.encode(bytes1);

            return new String(resultBytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    /**
     * DES加密
     * @param encryptData 待加密字符串
     * @param encryptKey 加密密钥（key的前8位作为偏移向量）
     * @return String
     * @throws Exception
     */
    public static String encrypt(String encryptData, String encryptKey)throws Exception {
        String strKey = StringUtils.fillStrWithChar(encryptKey,'F', 8);
        byte [] b_data = encryptData.getBytes("UTF-8");
        byte [] b_key = strKey.getBytes("UTF-8");
        byte [] b_iv = strKey.substring(0,8).getBytes("UTF-8");
        IvParameterSpec iv = new IvParameterSpec(b_iv);
        SecretKeySpec key = new SecretKeySpec(b_key, "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte [] b_result = cipher.doFinal(b_data);
        return  StringUtils.bytesToHexString(b_result);
    }

    public static String fillStrWith_F_End(String str, int len) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < len; ++i) {
            sb.append('F');
        }

        return str != null && str.length() != 0?(str.length() < len?str + sb.toString().substring(str.length(), len):str.substring(str.length() - len, str.length())):sb.toString();
    }


    public static void main(String[] args) throws Exception {

        String timeStamp = "20180211.180735";
        String appkey = "3f82eca4a95141f3889e778d3817cb31";
        String appsecret = "CdkfbgPgIoSv9OzaHNd1vAlvcD6gNZGd";

        String body = "{\"mchtType\":\"04\",\"firCateCode\":\"30000\",\"secCateCode\":\"31100\",\"thdCateCode\":\"31108\",\"addressCode\":\"110101\",\"mchtName\":\"接口进件商户20180208182307\",\"mchtSimpleName\":\"进商\",\"mchtContAddr\":\"重庆市北部新区星光五路3号\",\"mchtEmail\":\"10@263.com\",\"mchtPersonName\":\"小丹尼\",\"mchtPhone\":\"13100000003\",\"mchtLicnType\":\"01\",\"mchtLicnNo\":\"921101010000000025\",\"serviceList\":[{\"rate\":2.6,\"serviceID\":1},{\"rate\":2.7,\"serviceID\":2},{\"rate\":2.8,\"serviceID\":3}],\"setlType\":\"01\",\"setlAcctType\":\"2\",\"accountBoss\":\"2\",\"setlAcctName\":\"金贝贝\",\"setlAcctNo\":\"20-123456789012345\",\"setlBankCode\":\"102\",\"setlSubBranchCode\":\"102121000447\",\"setlBankPhone\":\"18692827190\",\"mchtPicUrlList\":[{\"mchtPicType\":\"01\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"},{\"mchtPicType\":\"02\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"},{\"mchtPicType\":\"07\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"},{\"mchtPicType\":\"08\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"},{\"mchtPicType\":\"09\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"},{\"mchtPicType\":\"18\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"},{\"mchtPicType\":\"19\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"},{\"mchtPicType\":\"23\",\"mchtPicUrl\":\"5cdfaff9885c4629b18873e9a745d19f\"}]}";

        String sign = SecurityUtils.calcSign(timeStamp, appkey, appsecret, body);
        System.out.println(sign);
    }
}
