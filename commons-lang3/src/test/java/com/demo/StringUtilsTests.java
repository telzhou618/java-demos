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
public class StringUtilsTests extends StringUtils {

    @Test
    public void test() {
        // 缩略字符串的一些高级用法 ，超过用...表示，默认截取长度不能小于3,否则抛出异常。
        log.info(abbreviate("截取一段文本测试", 6));
        // 用后面字符串包装前面字符串
        log.info(wrap("包装字符串", "\'"));
        // 转大写
        log.info(upperCase("hello"));
        // 首字母大写
        log.info(capitalize("hello"));
        // 大写转小写，小写转大写
        log.info(swapCase("Hello Word！"));
    }

}
