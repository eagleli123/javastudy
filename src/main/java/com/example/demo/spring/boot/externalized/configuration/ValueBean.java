package com.example.demo.spring.boot.externalized.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author: lihui
 * @date: 2020-09-15
 */
@Data
@Component
public class ValueBean {
    @Value("${server.port}")
    private String serverPort;
}

