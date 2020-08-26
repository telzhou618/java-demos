package com.example;

import com.google.common.base.Charsets;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhougaojun
 */
public class KetamaHashTest {

    private static ThreadLocal<MessageDigest> md5Local = new ThreadLocal<MessageDigest>();

    @Test
    public void test() {
        long rv = 0;
        byte[] bKey = computeMd5("hello");
        rv = (long) (bKey[3] & 0xFF) << 24 | (long) (bKey[2] & 0xFF) << 16
                | (long) (bKey[1] & 0xFF) << 8 | bKey[0] & 0xFF;

        long result = rv & 0xffffffffL;
        System.out.println(result);
    }

    public static byte[] computeMd5(String k) {
        MessageDigest md5 = md5Local.get();
        if (md5 == null) {
            try {
                md5 = MessageDigest.getInstance("MD5");
                md5Local.set(md5);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("MD5 not supported", e);
            }
        }
        md5.reset();
        md5.update(k.getBytes(Charsets.UTF_8));
        return md5.digest();
    }

}
