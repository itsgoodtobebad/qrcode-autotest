package com.itsgoodtobebad.qrcode.utils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Map相关工具类
 * @author majunhui
 * @date 2016/7/27.
 * */
public class MapUtil {

    public static String printMap(Map map){
        StringBuffer sb = new StringBuffer();
        Iterator header = map.entrySet().iterator();
        while(header.hasNext()) {
            Map.Entry entry = (Map.Entry)header.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            sb.append(key+"="+value + "\n");
        }
        if (sb.length()>0) {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    public static String toNotifySignData(Map map){
        StringBuffer sb = new StringBuffer();
        Iterator header = map.entrySet().iterator();
        while(header.hasNext()) {
            Map.Entry entry = (Map.Entry)header.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            sb.append(key+"="+value);
        }
        return sb.toString();
    }

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return map;
        }
        Map<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    private static class MapKeyComparator implements Comparator<String> {
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }

}
