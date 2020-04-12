package com.example.controller;

import com.example.service.UserSingletonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 单例模式实现
 *
 * @author zhougaojun
 */
@RestController
public class SingletonController {


    /**
     * 性能高安全的单例模式，推荐方式
     */
    @GetMapping("/user/singleton")
    public String getUserSingleton() {
        return UserSingletonService.getInstance().toString();
    }

    /**
     * 性能差安全的单例模式，锁粒度过大
     */
    @GetMapping("/user/singleton2")
    public String getUserSingleton2() {
        return UserSingletonService.getInstance2().toString();
    }

    /**
     *  不安全的单利模式，高并发先无法保证单例
     */
    @GetMapping("/user/singleton3")
    public String getUserSingleton3() {
        return UserSingletonService.getInstance3().toString();
    }
}
