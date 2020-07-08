package com.example.demo.spring.application.context.sample7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lihui
 * @date: 2020-06-30
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MyService {
    private MyDao myDao;
}
