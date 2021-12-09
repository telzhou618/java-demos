package com.example.spring;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author zhougaojun
 * @since 2021/10/20
 */
public class SpringMain {

    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes(StandardCharsets.UTF_8)));
        System.out.println(org.apache.commons.codec.digest.DigestUtils.md5Hex("123456"));
    }
}
