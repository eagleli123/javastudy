package com.example.demo.reflect;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.JacksonUtil;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: lihui
 * @date: 2020-06-02
 */
public class MethodReflectStudy {
    public static void main(String[] args) throws NoSuchMethodException {
        Method funMethod = MethodReflectStudy.class.getDeclaredMethod("fun", Integer.class, List.class);
        System.out.println(funMethod);
        System.out.println(getMethodInfo(funMethod));
        Method fun2Method = MethodReflectStudy.class.getDeclaredMethod("fun2");
        System.out.println(fun2Method);
        System.out.println(getMethodInfo(fun2Method));

        Integer integer = 2;
        List<String> list = Lists.newArrayList("123", "456", "789");
        Object[] methodArgs = {integer, list};
        System.out.println(getParamDataInfo(funMethod, methodArgs));
        System.out.println(getParamDataInfo(fun2Method, new Object[] {}));
    }

    public static String getMethodInfo(Method method) {
        return method.getReturnType().getSimpleName() + " " + method.getName() + "(" + getParamTypesInfo(method) + ")";
    }

    public static String getParamTypesInfo(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (ArrayUtils.isNotEmpty(parameterTypes)) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < parameterTypes.length; i++) {
                result.append(parameterTypes[i].getSimpleName()).append(",");
            }
            return result.substring(0, result.length() - 1);
        }
        return "";
    }

    public MethodReflectStudy fun(Integer integer, List<String> list) {
        System.out.println(integer + " " + list);
        return new MethodReflectStudy();
    }

    public void fun2() {
    }

    public static String getParamDataInfo(Method method, Object[] args) {
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        Map<String, Object> paramData = new LinkedHashMap<>();
        if (args != null && paramNames != null) {
            for (int i = 0, len = args.length; i < len; i++) {
                if (args[i] instanceof Serializable) {
                    paramData.put(paramNames[i], JacksonUtil.writeValueAsString(args[i]));
                } else if (args[i] instanceof MultipartFile) {
                    MultipartFile file = (MultipartFile) args[i];
                    paramData.put(paramNames[i], file.getName());
                } else {
                    paramData.put(paramNames[i], args[i]);
                }
            }
        }
        return JacksonUtil.writeValueAsString(paramData);
    }
}
