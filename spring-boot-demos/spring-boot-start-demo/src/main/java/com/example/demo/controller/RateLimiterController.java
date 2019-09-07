package com.example.demo.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  guava 令牌通限流算法
 *
 * @description: RateLimiterController
 * @author: zhougaojun
 * @date: 2019/07/02
 */
@RestController
public class RateLimiterController {

    /**
     * 每秒产生10个令牌
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(10);

    @GetMapping("/limit/test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        if (rateLimiter.tryAcquire()) {
            return "success";
        }
        throw new RuntimeException("服务器繁忙");
    }
}
