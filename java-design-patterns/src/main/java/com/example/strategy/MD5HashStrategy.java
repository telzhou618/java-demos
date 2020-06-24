package com.example.strategy;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5HashStrategy implements HashStrategy {

    @Override
    public String hash(String str) {
        return DigestUtils.md5Hex(str);
    }
}
