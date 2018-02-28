package com.itsgoodtobebad.qrcode.utils;


import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Liliangxi on 2017/6/9.
 */
public class StringUtils {
    public static String bytesToHexString(byte[] bytes){
        StringBuilder stringBuilder = new StringBuilder("");
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 字符串补位, 不足长度补位, 超过长度则截取
     * @param str
     * @param fChar
     * @param len
     * @return str
     */
    public static String fillStrWithChar(final String str, char fChar, int len) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(fChar);
        }
        if (str == null || str.isEmpty()) {
            return sb.toString();
        }
        if (str.length() < len) {
            return str + sb.toString().substring(str.length(), len);
        } else {
            return str.substring(str.length() - len, str.length());
        }
    }

    /***
     * Map转key=value这样的连续字符串
     * @param map
     * @return
     */
    public static String mapToSortedString(Map<String, String> map){
        if((map == null) && (map.size() == 0)){
            return "";
        }
        TreeMap<String, String> treeMap = new TreeMap<String, String>(map);

        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            sb.append(entry.getKey() + "=" + entry.getValue());
        }

        return sb.toString();
    }

    public static int[] stringToIntArray(String input){
        if((null == input) || (input.length() == 0)){
            return new int[0];
        }

        int[] output = new int[input.length()];
        for(int i=0;i<input.length();i++){
            output[i] = input.charAt(i) - '0';
        }

        return output;
    }

    public static void main(String[] args) {
        int[] test = StringUtils.stringToIntArray("13013000002322");

        System.out.println("test");
    }

}
