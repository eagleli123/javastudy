package com.example.demo.java.annotation;

import java.lang.reflect.Field;

/**
 * @author: lihui
 * @date: 2020-06-28
 */

public class SensitiveUtil {

    /**
     * 加密数据
     */
    public static Object encryptJavaBean(Object o) {
        try {
            Class<? extends Object> c = o.getClass();
            Field[] fields = c.getDeclaredFields();// 获取所有属性值
            for (Field f : fields) {
                f.setAccessible(true);
                SensitiveInfo annotation = f.getAnnotation(SensitiveInfo.class); // 获取属性上的注解
                if (annotation != null && String.class.equals(f.getGenericType())) { // 有此类注解
                    SensitiveType type = annotation.type();
                    // 判断注解类型
                    switch (type) {
                        case PHONE:// 手机号
                            f.set(o, encryptPhone(f.get(o).toString()));
                            break;
                        case USER_NAME:// 用户名
                            f.set(o, encryptUsername(f.get(o).toString()));
                            break;
                        default:
                            break;
                    }
                }
            }
            return o;
        } catch (Exception e) {
            return o;
        }
    }

    /**
     * 修改手机号
     */
    public static String encryptPhone(String phone) {
        return phone.substring(0, 3) + "****" + phone.substring(phone.length() - 4, phone.length());
    }

    /**
     * 修改用户名
     */
    public static String encryptUsername(String username) {
        int length = username.length();
        String sss = "";
        for (int i = 1; i < length; i++) {
            sss = sss + '*';
        }
        return username.substring(0, 1) + sss;
    }
}

