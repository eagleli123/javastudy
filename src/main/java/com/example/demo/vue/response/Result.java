package com.example.demo.vue.response;

/**
 * @author: lihui
 * @date: 2020-08-19
 */
public class Result {
    //响应码
    private int code;

    public Result(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}

