package com.example.demo.spring.boot.externalized.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lihui
 * @date: 2020-09-16
 */
@Configuration
public class Config {

    @Bean
    @ConfigurationProperties("server")
    public ConfigurationPropertiesBean configurationPropertiesBean() {
        return new ConfigurationPropertiesBean();
    }
}
