package com.example.jsoup;

import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * @author zhougaojun
 * @since 2021/10/21
 */
public class JsoupMain {

    private static final Pattern PATTERN = Pattern.compile("^http://\\w+\\.dxy\\.(cn|net)/bbs/(topic|thread)/\\d+$");
    private static final Pattern PATTERN2 = Pattern.compile("^http://www\\.dxy\\.(cn|net)/bbs/post/view\\?bid=\\d+&id=\\d+.*$");

    public static void main(String[] args) {

        String html = "几个帖子，申请加分，呵呵 <br /><br /><a href=\"http://news.dxy.cn/bbs/topic/17981200\" target=\"_blank\" class=\"ilink unline\" rel=\"nofollow\">http://news.dxy.cn/bbs/topic/17981200</a><br /><a href=\"http://www.dxy.cn/bbs/post/view?bid=116&id=17949881&sty=1\" target=\"_blank\" class=\"ilink unline\" rel=\"nofollow\">http://www.dxy.cn/bbs/post/view?bid=116&id=17949881&sty=1</a><br /><a href=\"http://www.dxy.cn/bbs/post/view?bid=116&id=17955694&sty=1\" target=\"_blank\" class=\"ilink unline\" rel=\"nofollow\">http://www.dxy.cn/bbs/post/view?bid=116&id=17955694&sty=1</a>\n";
        Document document = Jsoup.parse(html);
        Elements elements = document.getElementsByTag("a");
        elements.forEach(element -> {
            String href = element.attr("href");
            if (PATTERN.matcher(href).find()) {
                /**
                 * 匹配 http://news.dxy.cn/bbs/topic/17981200 或
                 *  http://news.dxy.cn/bbs/thread/17981200
                 */
                URI uri = URI.create(href);
                String path = uri.getPath();
                int id = Integer.parseInt(path.substring(path.lastIndexOf("/") + 1));
                element.attr("href", "https://www.dxy.cn/bbs/newweb/pc/post/" + id);
            } else if (PATTERN2.matcher(href).find()) {
                /**
                 * 匹配  http://www.dxy.cn/bbs/post/view?bid=116&id=17949881&sty=1
                 */
                String id = HttpUtil.decodeParamMap(href, StandardCharsets.UTF_8).get("id");
                element.attr("href", "https://www.dxy.cn/bbs/newweb/pc/post/" + id);
            }
        });
        System.out.println(Parser.unescapeEntities(document.html(), false));
    }
}
