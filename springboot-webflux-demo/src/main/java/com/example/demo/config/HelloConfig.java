package com.example.demo.config;

import com.example.demo.handler.HelloHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * HelloConfig
 *
 * @author zhougaojun
 * @date 2019/09/30
 */
@Configuration
public class HelloConfig {

    @Bean
    public RouterFunction<ServerResponse> hello(HelloHandler handler) {
        return RouterFunctions.route(RequestPredicates.path("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                handler::hello);
    }
}
