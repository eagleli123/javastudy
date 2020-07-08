package com.example.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

/**
 * @author: lihui
 * @date: 2020-06-30
 */
public class GoogleCommonCache {
    public static void main(String[] args) throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder().recordStats()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .maximumSize(1)
                .build();
        System.out.println(cache.getIfPresent("hello"));
        cache.put("hello", "world");
        System.out.println(cache.getIfPresent("hello"));
        Thread.sleep(5000);
        System.out.println(cache.getIfPresent("hello"));
    }
}
