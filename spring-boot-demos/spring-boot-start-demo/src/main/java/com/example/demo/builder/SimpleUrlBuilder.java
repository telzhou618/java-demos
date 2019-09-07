package com.example.demo.builder;

import lombok.NonNull;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiPredicate;

/**
 * SimpleUrlBuilder
 *
 * @author zhougaojun
 * @date 2019/07/28
 */
public class SimpleUrlBuilder implements Builder<String> {

    private String home;
    private Map<String, Object> params;

    private SimpleUrlBuilder(String home) {
        this.home = home;
        this.params = new HashMap<>();
    }

    public static SimpleUrlBuilder create(@NonNull String home) {
        return new SimpleUrlBuilder(home);
    }

    public SimpleUrlBuilder addParam(String name, Object value) {
        this.params.put(name, value);
        return this;
    }

    public SimpleUrlBuilder addParamIf(String name, Object value, BiPredicate predicate) {
        if (predicate.test(name, value)) {
            this.params.put(name, value);
        }
        return this;
    }

    public SimpleUrlBuilder addParamIfNotNull(String name, Object value) {
        this.addParamIf(name, value, (k, v) -> Objects.nonNull(k) && Objects.nonNull(v));
        return this;
    }

    public SimpleUrlBuilder addParamIfNotBlank(String name, Object value) {
        this.addParamIf(name, value, (k, v) ->
                Objects.nonNull(k)
                        && Objects.nonNull(v) &&
                        !StringUtils.isEmpty(k) && !StringUtils.isEmpty(v));
        return this;
    }

    @Override
    public String build() {
        String parmsStr = paramsConvertUrl();
        int index = home.indexOf("?");
        if (index > 0) {
            if (index != home.length() - 1) {
                return home + "&" + parmsStr;
            } else {
                return home + parmsStr;
            }
        } else {
            return home + "?" + parmsStr;
        }
    }

    private String paramsConvertUrl() {
        StringBuilder urlParams = new StringBuilder();
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            urlParams.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String urlParamsStr = urlParams.toString();
        return urlParamsStr.substring(0, urlParamsStr.length() - 1);
    }

    public static void main(String[] args) {
        SimpleUrlBuilder simpleUrlBuilder = SimpleUrlBuilder.create("http://www.baidu.com?")
                .addParamIfNotBlank("name", "zhangsan")
                .addParamIfNotBlank("age", 18)
                .addParamIfNotNull("addr", "");

        System.out.println(simpleUrlBuilder.build());

    }

}
