package com.example.demo.spring.application.context.sample2;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: lihui
 * @date: 2020-06-29
 */
@Configuration
public class Config {

    @Autowired
    private DataSource dataSource;

    @Bean
    public RepositoryOne repositoryOne(DataSource dataSource) {
        return new RepositoryOne(dataSource);
    }

    @Bean
    public RepositoryTwo repositoryTwo() {
        return new RepositoryTwo(dataSource);
    }

    @Bean
    public RepositoryThree repositoryThree() {
        return new RepositoryThree();
    }

    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }
}
