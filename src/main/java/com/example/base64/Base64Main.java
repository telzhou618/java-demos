package com.example.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/** java8 自带bas464编码、解码
 * @author zhougaojun
 * @since 2021/7/29
 */
public class Base64Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "runoob?java8";
        System.out.println("原字符串:" + str);
        // base64编码
        String base64encodedString = Base64.getEncoder().encodeToString(str.getBytes("utf-8"));
        System.out.println("编码后:" + base64encodedString);
        // 解码
        byte[] base64decodedBytes = Base64.getDecoder().decode(base64encodedString);
        System.out.println("解码后: " + new String(base64decodedBytes, "utf-8"));
    }
}
