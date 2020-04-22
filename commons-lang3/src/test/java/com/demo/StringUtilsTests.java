package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * StringUtils demo
 *
 * @author zhougaojun
 */
@Slf4j
public class StringUtilsTests {

    /**
     * 截取文本，超过用...表示，默认截取长度不能小于3,否则抛出异常。
     */
    @Test
    public void abbreviate() {
        log.info(StringUtils.abbreviate("截取一段文本测试", 6));
    }
}
