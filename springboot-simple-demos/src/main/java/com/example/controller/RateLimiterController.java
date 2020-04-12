package com.example.controller;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * guava 令牌通限流算法
 *
 * @author zhougaojun
 */
@Slf4j
@RestController
public class RateLimiterController {

    /**
     * 每秒产生10个令牌
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(10);

    @GetMapping("/limit/test")
    public String test() {
        if (rateLimiter.tryAcquire()) {
            log.info("请求处理成功！");
            return "success";
        }
        throw new RuntimeException("服务器繁忙");
    }
}
