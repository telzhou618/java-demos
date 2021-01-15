package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.server.PathContainer;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhougaojun
 */
public class PathPatternTest {
    private static final List<RedirectPattern> REDIRECT_PATTERN_DATA = new ArrayList<>();

    private static final String _3G_ROOT = "http://3g.baidu.cn/bbs";

    static {
        REDIRECT_PATTERN_DATA.add(new RedirectPattern("/pc/home*", "/"));
        REDIRECT_PATTERN_DATA.add(new RedirectPattern("/pc/board/{boardId:\\d+}*", "/board/{boardId}"));
        REDIRECT_PATTERN_DATA.add(new RedirectPattern("/pc/post/{postId:\\d+}*", "/topic/{postId}"));
    }

    @Data
    @AllArgsConstructor
    private static class RedirectPattern {
        private String pathPattern;
        private String redirectPath;
    }

    public static void main(String[] args) {

        // 将/pc/post/41009677 转换为 /topic/41009677

        PathContainer pathContainer = PathContainer.parsePath("/pc/post/41009677");
        PathPattern pathPattern = new PathPatternParser().parse("/pc/post/{postId:\\d+}*");
       /* PathPattern pathPattern2 = new PathPatternParser().parse("/pc/board/{boardId:\\d+}**");
        PathPattern pathPattern3 = new PathPatternParser().parse("/pc/home**");

        System.out.println(pathPattern.matches(pathContainer));
        System.out.println(pathPattern.matchAndExtract(pathContainer));

        System.out.println(pathPattern2.matchAndExtract(PathContainer.parsePath("/pc/board/2131?a=213")));
        System.out.println(pathPattern3.matches(PathContainer.parsePath("/pc/home")));*/

        System.out.println(pathPattern.matches(pathContainer));
        System.out.println(pathPattern.matchAndExtract(pathContainer));

        if (pathPattern.matches(pathContainer)) {
            Map<String, String> uriVariables = pathPattern.matchAndExtract(pathContainer).getUriVariables();
            String http = UriComponentsBuilder.fromUriString("http://3g.baidu.cn/bbs/topic/{postId}").buildAndExpand(uriVariables).toString();
            System.out.println(http);
        }


    }
}
