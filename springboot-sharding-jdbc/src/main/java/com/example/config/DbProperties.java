package com.example.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author jameszhou
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DbProperties {

    private Map<String, DbProp> db;

    @Data
    public static class DbProp {
        private String url;
        private String username;
        private String password;
    }
}
