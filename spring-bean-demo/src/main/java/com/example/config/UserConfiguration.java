package com.example.config;

import com.example.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhougaojun
 */
@Configuration
public class UserConfiguration {

    @Bean
    public User user() {
        return new User();
    }
}
