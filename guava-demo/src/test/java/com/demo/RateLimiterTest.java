package com.demo;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** 令牌桶限流
 * @author zhougaojun
 */
@Slf4j
public class RateLimiterTest {

    private static RateLimiter rateLimiter = RateLimiter.create(1);
    private static Executor executor = Executors.newFixedThreadPool(5);

    /**
     * 简单限流操作
     */
    @Test
    public void test() {
        for (int x = 0; x < 5; x++) {
            executor.execute(() -> {
                log.info(Thread.currentThread().getName() + ":" + rateLimiter.tryAcquire());
            });
        }
    }

    /**
     * 设置超时时间
     */
    @Test
    public void test2() {
        log.info(Thread.currentThread().getName() + ":" + rateLimiter.tryAcquire(2, 2, TimeUnit.SECONDS));
    }
}
