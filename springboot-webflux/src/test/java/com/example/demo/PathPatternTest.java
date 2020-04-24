package com.example.demo;

import org.junit.Test;
import org.springframework.http.server.PathContainer;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Map;

/**
 * @author jameszhou
 */
public class PathPatternTest {

    @Test
    public void test() {
        // 将/pc/post/41009677 -> 转换为 /topic/41009677

        PathContainer pathContainer = PathContainer.parsePath("/pc/post/41009677");
        PathPattern pathPattern = new PathPatternParser().parse("/pc/post/{postId:\\d+}*");

        System.out.println(pathPattern.matches(pathContainer));
        System.out.println(pathPattern.matchAndExtract(pathContainer));

        if (pathPattern.matches(pathContainer)) {
            Map<String, String> uriVariables = pathPattern.matchAndExtract(pathContainer).getUriVariables();
            String http = UriComponentsBuilder.fromUriString("http://3g.test.cn/bbs/topic/{postId}").buildAndExpand(uriVariables).toString();
            System.out.println(http);
        }
    }
}
