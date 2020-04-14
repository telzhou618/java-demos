package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jameszhou
 */
@Configuration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        /**
         *  允许来自 http://domain2.com 的跨域访问，且限定路径为 /api,方法为POST或者GET
         */
        registry.addMapping("/api/**")
                .allowedOrigins("http://domain2.com")
                .allowedMethods("POST", "GET");

        /**
         *  允许所有跨域访问，这样写
         *  registry.addMapping("/**");
         */
    }
}
