package com.example.demo.spring.boot.externalized.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lihui
 * @date: 2020-09-15
 */
@RestController
@RequestMapping("/one")
public class OneController {

    @Autowired
    private ConfigurationPropertiesBean oneBean;

    @Autowired
    private Environment environment;

    @Autowired
    private ValueBean valueBean;

    @GetMapping
    public ConfigurationPropertiesBean get() {
        return oneBean;
    }

    @GetMapping("/new")
    public ConfigurationPropertiesBean newOneBean() {
        return new ConfigurationPropertiesBean();
    }

    @GetMapping("/value")
    public ValueBean getValueBean() {
        return valueBean;
    }

    @GetMapping("/env")
    public String getEnv() {
        return environment.getProperty("server.port");
    }
}
