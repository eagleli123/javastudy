package com.example.demo.collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.beanutils.BeanMap;

/**
 * @author: lihui
 * @date: 2020-07-11
 */
public class BeanMapMain {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class BeanObject {
        int age;
        boolean sex;
    }

    public static void main(String[] args) {
        BeanMap beanMap = new BeanMap(new BeanObject(12, true));
        System.out.println(beanMap.get("class"));
        System.out.println(beanMap.get("age"));
        beanMap.put("age", 123);
        System.out.println(beanMap.get("age"));
    }
}
