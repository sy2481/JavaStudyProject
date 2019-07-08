package com.sunzhouyu.thread.test02;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Author sunyi
 * @Date: 2019/1/23
 */
public class dateutil {
    public static void main(String[] args) {
        String dt_register = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dt_register = simpleDateFormat.format(df2.parse("2018-10-11 18:00:22"));
        } catch (Exception e) {
            e.printStackTrace();
        }
       // System.out.println(dt_register);
        System.out.println(getDateTimeShort());
    }
    //201901281428417
    //20190128142843

    private static Calendar cale = Calendar.getInstance();

    private static final String DATETIME_FORMAT_SHORT = "yyyyMMddHHmmss";

    private static SimpleDateFormat sdf_datetime_format_short = new SimpleDateFormat(DATETIME_FORMAT_SHORT);

    public static String getDateTimeShort() {
        try {
            return sdf_datetime_format_short.format(cale.getTime());
        } catch (Exception e) {
            //logger.debug("DateUtil.getDateTime():" + e.getMessage());
            return "";
        }
    }

}
