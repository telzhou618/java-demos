package com.example.demo;

import lombok.Data;
import org.junit.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * @author zhougaojun
 * @date 2019/10/18
 */
public class AppTest {

    private WebClient webClient = WebClient.create("https://api.github.com");

    @Data
    public static class GithubRepo {
        private String current_user_url;
        private String current_user_authorizations_html_url;
        private String authorizations_url;
    }

    @Test
    public void test1() {
        Mono<Map> mono = webClient.get().retrieve().bodyToMono(Map.class);
        System.out.println(mono.block().get("current_user_url"));
        System.out.println(mono.block().get("authorizations_url"));
    }
}
