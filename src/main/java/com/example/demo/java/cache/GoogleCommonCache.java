package com.example.demo.java.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.junit.Test;

/**
 * @author: lihui
 * @date: 2020-06-30
 */
@Slf4j
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

    @Test
    public void loadTest() throws ExecutionException, InterruptedException {
        LoadingCache<Pair<Integer, DateTime>, Double> interestsCache =
                CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build(
                        new CacheLoader<Pair<Integer, DateTime>, Double>() {
                            @Override
                            public Double load(Pair<Integer, DateTime> accountPagePair) throws Exception {
                                log.info("load.........");
                                return null;
                            }
                        }
                );
        DateTime dateTime1 = DateTime.now().withTimeAtStartOfDay();
        DateTime dateTime2 = DateTime.now().withTimeAtStartOfDay();
        log.info("dateTime1.equals(dateTime2) : {}", dateTime1.equals(dateTime2));
        interestsCache.get(Pair.of(1, dateTime1));
        interestsCache.get(Pair.of(1, dateTime2));
        interestsCache.get(Pair.of(1, DateTime.now()));
        Thread.sleep(10000);
        interestsCache.get(Pair.of(1, dateTime1));
        interestsCache.get(Pair.of(1, dateTime2));
        interestsCache.get(Pair.of(1, DateTime.now()));
    }

    @Test
    public void keyTest() throws ExecutionException, InterruptedException {
        LoadingCache<String, String> interestsCache =
                CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.HOURS).build(
                        new CacheLoader<String, String>() {
                            @Override
                            public String load(String lang) throws Exception {
                                return lang;
                            }
                        }
                );

    }
}
