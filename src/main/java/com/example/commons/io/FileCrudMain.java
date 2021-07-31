package com.example.commons.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author zhougaojun
 * @since 2021/7/29
 */
@Slf4j
public class FileCrudMain extends FileUtils {

    public static void main(String[] args) throws IOException {

        // 文件大小格式化输出
        System.out.println(byteCountToDisplaySize(100830001L));
        // 获取临时目录
        System.out.println(getTempDirectory().getAbsolutePath());
        // 获取临时目录
        System.out.println(getTempDirectoryPath());

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
