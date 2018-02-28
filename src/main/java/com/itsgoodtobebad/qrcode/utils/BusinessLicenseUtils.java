package com.itsgoodtobebad.qrcode.utils;

/**
 * @author liliangxi.
 *         Created on 2018/2/1.
 */
public class BusinessLicenseUtils {

    public static String getVerifyBit(String preString) throws Exception {
        // 北京东城区编码110101
        // 21表示私营有限公司

        if(null == preString){
            throw new Exception("营业执照前置编号为空");
        }

        if(preString.length() == 14) {
            int[] intArray = StringUtils.stringToIntArray(preString);
            return getCheckCode14(intArray);
        }else if(preString.length() == 17){
            return getCheckCode17(preString);
        }else{
            throw new Exception("营业执照前置编号长度非14或17");
        }

    }


    private static String  getCheckCode14(int[] ints){
        if (null != ints && ints.length > 1) {
            int ti = 0;
            int si = 0;  // pi|11+ti
            int cj = 0;  // （si||10==0？10：si||10）*2
            int pj = 10;  // pj=cj|11==0?10:cj|11
            for (int i=0;i<ints.length;i++) {
                ti = ints[i];
                pj = (cj % 11) == 0 ? 10 : (cj % 11);
                si = pj + ti;
                cj = (0 == si % 10 ? 10 : si % 10) * 2;
                if (i == ints.length-1) {
                    pj = (cj % 11) == 0 ? 10 : (cj % 11);
                    return (pj == 1 ? 1 : 11 - pj) + "";
                }
            }
        }
        return "";
    }

    private static String getCheckCode17(String input){
        int sum = 0;
        String str = "0123456789ABCDEFGHJKLMNPQRTUWXY";
        int[] ws = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
        for(int i=0;i< 17;i++){
            sum = sum + str.indexOf(input.charAt(i))*ws[i];
        }

        int code = 31 - ( sum % 31 );
        if(code == 31){
            code = 0;
        }
        return str.charAt(code) + "";

    }


    public static void main(String[] args) {


        System.out.println(BusinessLicenseUtils.getCheckCode17("91350100M000100Y4"));

    }

}
