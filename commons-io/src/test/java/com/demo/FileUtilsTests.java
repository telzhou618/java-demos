package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * FileUtils demo
 *
 * @author zhougaojun
 */
@Slf4j
public class FileUtilsTests extends FileUtils {

    @Test
    public void testBase() throws IOException {
        // 文件大小格式化输出
        log.info(byteCountToDisplaySize(100830001L));
        // 获取临时目录
        log.info(getTempDirectory().getAbsolutePath());
        // 获取临时目录
        log.info(getTempDirectoryPath());
    }

    @Test
    public void testFileCrud() throws IOException {
        // 创建文件
        File file = getFile(getTempDirectory(), "temp.txt");
        touch(file);
        log.info("创建文件:{}" + file.getAbsolutePath());
        // 写文件
        String content = "Hello World!";
        writeStringToFile(file, content, StandardCharsets.UTF_8);
        log.info("写文件:{}", content);
        // 读文件
        log.info("读文件:{}", readFileToString(file, StandardCharsets.UTF_8));
        // 删文件
        log.info("删除文件:{}", deleteQuietly(file));
        // 移动文件
    }

}
