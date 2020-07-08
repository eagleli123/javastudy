package com.example.demo.annotation.cglib;

import com.example.demo.annotation.SensitiveInfo;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: lihui
 * @date: 2020-06-28
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        final UserServiceImpl userService = MyBeanFactory.createService();
        userService.addUser("aj12345", "999");
        userService.updateUser();
        userService.deleteUser();

        Class<?> clazz = UserServiceImpl.class;
        // 获取 "方法参数" 上的注解的值
        Method method = clazz.getDeclaredMethod("addUser", String.class, String.class);
        String[] parameterNames = getMethodParameterNamesByAnnotation(method);
        System.out.println("\"方法参数\"上的注解值获取到" + Arrays.toString(parameterNames));
    }

    public static String[] getMethodParameterNamesByAnnotation(Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        System.out.println(method.getParameterTypes());
        System.out.println(method.getParameterAnnotations());
        if (parameterAnnotations == null || parameterAnnotations.length == 0) {
            return null;
        }
        String[] parameterNames = new String[parameterAnnotations.length];
        int i = 0;
        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof SensitiveInfo) {
                    SensitiveInfo param = (SensitiveInfo) annotation;
                    parameterNames[i++] = param.type().name();
                }
            }
        }
        return parameterNames;
    }
}
