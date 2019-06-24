package cn.itcast.user.util;

import cn.itcast.user.dataenum.DEnum;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author G.J.
 **/
public class Util {
    /**
     * @Description 将一个对象属性赋值给另一个属性
     * @Author G.J.
     **/
    public static void copyFieldToBean(Object srcObj, Object destObj) {
        Map<String, Object> srcMap = new HashMap<String, Object>();
        Field[] srcFields = srcObj.getClass().getDeclaredFields();
        for (Field srcField : srcFields) {
            try {
                srcField.setAccessible(true);
                srcMap.put(srcField.getName(), srcField.get(srcObj)); //获取属性值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Field[] destFields = destObj.getClass().getDeclaredFields();
        for (Field destField : destFields) {
            destField.setAccessible(true);
            if (srcMap.get(destField.getName()) == null) {
                continue;
            }
            try {
                destField.set(destObj, srcMap.get(destField.getName())); //给属性赋值
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @Description 从枚举类中配对key值
     * @Author G.J.
     **/
    public static String date(String date) {
        boolean has_task = false;
        String returnDate = "";
        for (DEnum u : DEnum.values()) {
            if (u.getCode().equals(date)) {
                has_task = true;
                returnDate = u.getDesc();
                System.out.println("code=" + u.getCode() + ",desc=" + u.getDesc());
                break;
            }
        }
        return returnDate;
    }

    /*
     * @Description 转为时间戳
     * @Author G.J.
     **/
    public static String dateToStamp(String date, String timeFormat) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormat);
        String TimeStamp = String.valueOf(simpleDateFormat.parse(date).getTime());
        return TimeStamp;
    }

    /*
     * @Description 求当前日期
     * @Author G.J.
     **/
    public static String getCurrentFormatDate(String formatDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        Date dateInstance = new Date();
        simpleDateFormat.applyPattern(formatDate);
        return simpleDateFormat.format(dateInstance);
    }

    /**
     * @Description 实体类转为map
     * @Author G.J.
     **/
    public static Map<String, Object> transBean2Map(Object obj) {
        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }


}
