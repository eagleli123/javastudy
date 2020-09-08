package com.example.demo.spring.application.intercept;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author: lihui
 * @date: 2020-09-02
 */
@Slf4j
public class MyResolver implements HandlerMethodArgumentResolver {

    private static final String NAME_ATTRIBUTE = "name";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("supportsParameter, {}", parameter);
        return parameter.hasParameterAnnotation(AddHello.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        log.info("resolveArgument, {}", request);
        return request == null ? null : "hello, " + request.getParameter(NAME_ATTRIBUTE);
    }
}
