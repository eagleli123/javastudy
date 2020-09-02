package com.example.demo.java.annotation;

import lombok.Data;

/**
 * @author: lihui
 * @date: 2020-06-28
 */
@Data
public class User {
    @SensitiveInfo(type = SensitiveType.USER_NAME)//根据名称进行脱敏
    private String name;

    private Character sex;

    private Integer age;

    private double weight;

    @SensitiveInfo(type = SensitiveType.PHONE)//根据手机进行脱敏
    private String phone;
}
