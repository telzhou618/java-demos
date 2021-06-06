package com.example.base64;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author zhougaojun
 */
public class Base64Test {

    @Test
    public void test1() {
        String a = "a";
        byte[] bytes = a.getBytes();
        for (byte b : bytes) {
            System.out.println(b);
            System.out.println(Integer.toBinaryString(b));
        }
    }

    @Test
    public void test2() {
        String a = "鸟";
        byte[] utf8Bytes = a.getBytes(StandardCharsets.UTF_8);
        for (byte b : utf8Bytes) {
            System.out.print(b);
            System.out.print("  ");
            System.out.println(Integer.toBinaryString(b));
        }
    }

    @Test
    public void test3() throws UnsupportedEncodingException {
        String a = "鸟";
        byte[] utf8Bytes = a.getBytes("gbk");
        for (byte b : utf8Bytes) {
            System.out.print(b);
            System.out.print("  ");
            System.out.println(Integer.toBinaryString(b));
        }
    }

    @Test
    public void base64Test() {
        System.out.println(Base64.getEncoder().encodeToString("hello".getBytes()));
    }


    @Test
    public void md5() throws NoSuchAlgorithmException {
        // DigestUtils 封装了JDK包中的
        System.out.println(DigestUtils.md5Hex("hello"));
        // JDK 包
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] bytes = digest.digest("hello".getBytes(StandardCharsets.UTF_8));
        System.out.println(Hex.encodeHex(bytes));
    }

    /**
     * Blowfish 对称加密算法
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        String value = "mrbird's blog";
        System.out.println("待加密值：" + value);
        // 加密算法
        String algorithm = "Blowfish";
        // 转换模式
        String transformation = "Blowfish";
        // --- 生成秘钥 ---
        // 实例化秘钥生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        // 初始化秘钥长度
        keyGenerator.init(128);
        // 生成秘钥
        SecretKey secretKey = keyGenerator.generateKey();
        // 生成秘钥材料
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), algorithm);
        System.out.println("Blowfish秘钥：" + Base64.getEncoder().encodeToString(secretKey.getEncoded()));

        // 实例化密码对象
        Cipher cipher = Cipher.getInstance(transformation);
        // 设置模式（ENCRYPT_MODE：加密模式；DECRYPT_MODE：解密模式）和指定秘钥
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // 加密
        byte[] encrypt = cipher.doFinal(value.getBytes());
        System.out.println("Blowfish加密结果：" + Base64.getEncoder().encodeToString(encrypt));
        // 解密
        // 设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decrypt = cipher.doFinal(encrypt);
        System.out.println("Blowfish解密结果：" + new String(decrypt));
    }
}
