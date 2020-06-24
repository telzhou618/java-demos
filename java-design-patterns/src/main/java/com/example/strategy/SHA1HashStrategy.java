package com.example.strategy;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA1HashStrategy implements HashStrategy {

    @Override
    public String hash(String str) {
        return DigestUtils.sha1Hex(str);
    }
}
