package com.example.demo.spring.application.ioc.scope;

import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lihui
 * @date: 2020-07-19
 */
@RestController
@RequestMapping("/scopes")
@Slf4j
public class ScopesController {

    @Resource(name = "requestScopedBean")
    private HelloMessageGenerator requestScopedBean;

    @Resource(name = "sessionScopedBean")
    private HelloMessageGenerator sessionScopedBean;

    @GetMapping("/request")
    public Map<String, String> getRequestScopeMessage() {
        Map<String, String> result = Maps.newLinkedHashMap();
        result.put("message", requestScopedBean.getMessage());
        result.put("requestScopedBean", requestScopedBean.toString());
        requestScopedBean.setMessage("Good morning!");
        return result;
    }

    @GetMapping("/session")
    public Map<String, String> getSessionScopeMessage() {
        log.info("getSessionScopeMessage(), sessionScopedBean:{}", sessionScopedBean);
        Map<String, String> result = Maps.newLinkedHashMap();
        result.put("message", sessionScopedBean.getMessage());
        result.put("sessionScopedBean", sessionScopedBean.toString());
        sessionScopedBean.setMessage("Good morning!");
        return result;
    }
}
