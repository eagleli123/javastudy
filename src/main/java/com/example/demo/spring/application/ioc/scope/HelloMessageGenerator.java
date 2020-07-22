package com.example.demo.spring.application.ioc.scope;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: lihui
 * @date: 2020-07-19
 */

@Getter
@Setter
public class HelloMessageGenerator {
    private String message;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode());
    }
}
