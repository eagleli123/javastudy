package com.example.demo.spring.boot.externalized.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: lihui
 * @date: 2020-09-15
 */
//@Component
@Data
public class ConfigurationPropertiesBean {
    private Integer port;
}

