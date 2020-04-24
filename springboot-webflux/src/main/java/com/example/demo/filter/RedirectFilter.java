package com.example.demo.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.server.PathContainer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhougaojun
 */
@Component
public class RedirectFilter implements WebFilter {

    private static final List<RedirectPattern> REDIRECT_PATTERN_DATA = new ArrayList<>();
    private static final String _3G_ROOT = "http://www.test.cn/base";

    static {
        REDIRECT_PATTERN_DATA.add(new RedirectPattern("/pc/home*", "/"));
        REDIRECT_PATTERN_DATA.add(new RedirectPattern("/pc/board/{boardId:\\d+}*", "/board/{boardId}"));
        REDIRECT_PATTERN_DATA.add(new RedirectPattern("/pc/post/{postId:\\d+}*", "/topic/{postId}"));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class RedirectPattern {
        private String pathPattern;
        private String redirectPath;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain webFilterChain) {
        ServerHttpRequest request = exchange.getRequest();
        String queryStr = request.getURI().getQuery();
        PathContainer pathContainer = request.getPath().contextPath();

        REDIRECT_PATTERN_DATA.forEach(data -> {
            PathPattern pathPattern = new PathPatternParser().parse(data.getPathPattern());
            String redirectPath = data.getRedirectPath();
            if (pathPattern.matches(pathContainer)) {

                Map<String, String> varMap = pathPattern.matchAndExtract(pathContainer).getUriVariables();
                String redirectUrl = UriComponentsBuilder.fromUriString(_3G_ROOT + redirectPath).buildAndExpand(varMap).toString();
                // 重定向
                return;
            }
        });
        return webFilterChain.filter(exchange);
    }
}
