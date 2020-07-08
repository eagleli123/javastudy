package com.example.demo.spring.application.context.sample2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lihui
 * @date: 2020-06-29
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RepositoryTwo {
    private DataSource dataSource;
}
