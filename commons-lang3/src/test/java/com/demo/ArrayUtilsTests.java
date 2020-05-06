package com.demo;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * @author zhougaojun
 */
public class ArrayUtilsTests {

    /**
     * 判断数组是否包含某一元素
     */
    @Test
    public void testContains() {
        for (String a : "测试|a|啊|bc".split("\\|")) {  // "|" 分隔是注意要加//,否则会分隔成单个字符
            System.out.print(a + ",");
        }
        // 测试,a,啊,bc,
        System.out.println();
        for (String a : "测试|a|啊|bc".split("|")) {
            System.out.print(a + ",");
        }
        // 测,试,|,a,|,啊,|,b,c,
        System.out.println();
        System.out.println(ArrayUtils.contains("测试|a|啊|bc".split("\\|"), "测试"));
        // true
        System.out.println();
        System.out.println(ArrayUtils.contains("测试|a|啊|bc".split("|"), "测试"));
        // false
    }
}
