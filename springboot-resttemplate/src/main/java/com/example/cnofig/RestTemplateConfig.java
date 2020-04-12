package com.example.cnofig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhougaojun
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @ConditionalOnMissingBean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
