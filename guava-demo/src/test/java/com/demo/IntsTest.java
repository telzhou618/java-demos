package com.demo;

import com.google.common.primitives.Ints;
import org.junit.Test;

/**
 * nts 工具类
 *
 * @author jameszhou
 */
public class IntsTest {

    /**
     * 将字符串转换为 Int 类型，无异常抛出
     */
    @Test
    public void testTryParse() {
        System.out.println(Ints.tryParse("123456789"));
        System.out.println(Ints.tryParse("1234567890000"));
        System.out.println(Ints.tryParse("1234567d"));
    }
}
