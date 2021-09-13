package com.example.apache.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author zhougaojun
 * @since 2021/9/13
 */
public class DigestUtilsTest {

    @Test
    public void base64Test(){
        String bs =  Base64.encodeBase64String("hello".getBytes(StandardCharsets.UTF_8));
        System.out.println(bs);
        System.out.println(StringUtils.newStringUtf8( Base64.decodeBase64(bs)));
    }

    @Test
    public void shaTest(){
        System.out.println(DigestUtils.sha1Hex("123456"));
        System.out.println(DigestUtils.sha256Hex("123456"));
        System.out.println(DigestUtils.sha512Hex("123456"));
    }
}
