package com.example.demo.annotation;

/**
 * @author: lihui
 * @date: 2020-06-28
 */
public class SensitiveMain {

    public static void main(String[] args) {

        // 数据脱敏
        User user = new User();
        user.setAge(23);
        user.setName("章鱼哥");
        user.setPhone("15639353333");
        user.setSex('m');
        user.setWeight(78.20);
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>脱敏实体类");
        System.err.println("脱敏之前-----------" + user.toString());
        System.err.println("脱敏之后-----------" + SensitiveUtil.encryptJavaBean(user).toString());
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>脱敏实单个数据");
        System.err.println(SensitiveUtil.encryptPhone("13300000000"));
        System.err.println(SensitiveUtil.encryptUsername("海绵宝宝"));

        String str = "hello";
        System.out.println(SensitiveUtil.encryptJavaBean(str));

    }
}
