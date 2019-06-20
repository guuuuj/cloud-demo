package cn.itcast.user.service;

import cn.itcast.user.util.Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author G.J.
 **/
public class replaceMSG {
    private static final int ONE_DAY_STAMP = 1000 * 60 * 60 * 24;

    /**
     * @Description 批量替换字符串
     * @Author G.J.
     **/
    /*public static void main(String[] args) {
        String a = "恭喜您注册成功，欢迎成为喜氏电子会员，登录手机为{mobile}，初始密码为{initPassword}。如有疑问请致电400-100-5767";
        String b = "mobile:111111,initPassword:22222";
        String[] str = b.split(",");
        for (int i = 0; i < str.length; i++) {
            String[] str1 = str[i].split(":");
            a = a.replace("{" + str1[0] + "}", str1[1]);
            System.out.println("-------->" + a);
        }
    }*/

    /*public static void main(String[] args) {
        Util.date1("2019-01-01");
    }*/
    public static void main(String[] args) {
        /*int betweenDays;
        try {
            String curDate = getCurrentFormatDate("yyyy-MM-dd");
            String curDateStamp = dateToStamp(curDate, "yyyy-MM-dd");
            String inRushDateStamp = dateToStamp("2019-07-07","yyyy-MM-dd");
            betweenDays = (int) ((Long.parseLong(inRushDateStamp) - Long.parseLong(curDateStamp)) / ONE_DAY_STAMP);
            System.out.println(betweenDays);
            //Util.date1("2019-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        String st = "";
        String[] st1 = null;
        int betweenDays = 0;
        String curDate = getCurrentFormatDate("yyyy-MM-dd");
        String curDateStamp = dateToStamp(curDate, "yyyy-MM-dd");
        String inRushDateStamp = dateToStamp("2019-07-07", "yyyy-MM-dd");
        try {
            Class clazz = Class.forName("cn.itcast.user.conf.Conf");
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                st = (String) field.get(clazz);
                st1 = st.split(",");
                if ((st1[0]).equals("2019-07-07")) {
                    betweenDays = (int) ((Long.parseLong(inRushDateStamp) - Long.parseLong(curDateStamp)) / ONE_DAY_STAMP) + Integer.parseInt(st1[1]);
                } else {
                    betweenDays = (int) ((Long.parseLong(inRushDateStamp) - Long.parseLong(curDateStamp)) / ONE_DAY_STAMP);
                }
            }
            System.out.println(betweenDays);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static String dateToStamp(String date, String timeFormat) {
        SimpleDateFormat simpleDateFormat = null;
        String TimeStamp = "";
        try {
            simpleDateFormat = new SimpleDateFormat(timeFormat);
            TimeStamp = String.valueOf(simpleDateFormat.parse(date).getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TimeStamp;
    }

    public static String getCurrentFormatDate(String formatDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date dateInstance = new Date();
        simpleDateFormat.applyPattern(formatDate);
        return simpleDateFormat.format(dateInstance);
    }
}
