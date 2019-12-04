package com.example.demo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * HelloHandler
 *
 * @author zhougaojun
 * @date 2019/09/30
 */
@Component
public class HelloHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        System.out.println(request.path());
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .header("Content-Type","text/plain; charset=utf-8")
                .body(BodyInserters.fromObject("Hello,中国 !"));
    }
}
