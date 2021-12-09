package com.example.design.patterns.proxy.jdk.api;

/**
 * @author zhougaojun
 */
public interface UserClient {

    @Url("http://www.baidu.com")
    String getUsername(Integer userId);
}
