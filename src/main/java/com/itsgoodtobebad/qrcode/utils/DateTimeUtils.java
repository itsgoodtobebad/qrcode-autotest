package com.itsgoodtobebad.qrcode.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Liliangxi on 2017/6/9.
 */
public class DateTimeUtils {
    /**
     * 得到指定日期UTC时间, 格式为"yyyyMMdd.HHmmss"
     * @return
     * String UTCTimestamp
     */
    public static String getUTCTimestamp(Date date, String formatterString) {
        DateFormat formatter = new SimpleDateFormat(formatterString);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT-0"));
        return formatter.format(date);
    }

    /**
     * 得到当前UTC时间, 格式为"yyyyMMdd.HHmmss"
     * @return
     * String UTCTimestamp
     */
    public static String getUTCTimestamp(String formatterString) {
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        return getUTCTimestamp(d, formatterString);
    }

    public static String getTimestamp(Date date, String formatterString){
        DateFormat formatter = new SimpleDateFormat(formatterString);
        return formatter.format(date);
    }

    public static String getTimestamp(String formatterString){
        Calendar c = Calendar.getInstance();
        Date d = c.getTime();
        return getTimestamp(d, formatterString);
    }

    public static void main(String[] args) {
        System.out.println(getUTCTimestamp("yyyyMMdd.HHmmss"));
        System.out.println(getTimestamp("yyyyMMddHHmmss"));
    }
}
