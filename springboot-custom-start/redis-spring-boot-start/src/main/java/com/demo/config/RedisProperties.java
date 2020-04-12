package com.demo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhougaojun
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "redis")
public class RedisProperties {

    private String host = "127.0.0.1";
    private int port = 6379;
    private String password;
    private int index = 0;
}
