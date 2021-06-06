package com.example.proxy.jdk;

/**
 * @author zhougaojun
 */
public interface UserClient {

    @Url("http://www.baidu.com")
    String getUsername(Integer userId);
}
