package com.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.junit.Test;

/**
 * @author jameszhou
 */
public class TestApp {

    @Test
    public void test() throws EncoderException, DecoderException {
        URLCodec urlCodec = new URLCodec();
        String str = urlCodec.encode("http://www.baidu.com/bbs/post?id=10&title=数据");
        System.out.println(str);
        System.out.println(urlCodec.decode(str));
    }
}
