package com.demo;

import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**
 * @author jameszhou
 */
@Slf4j
public class FilesTest {

    @Test
    public void test() throws Exception {
       File fileDir = Files.createTempDir();
        // 创建文件
        File file = new File(fileDir,"aaa.txt");
        Files.touch(file);
        log.info(file.getAbsolutePath());
        // 写文件
        Files.asCharSink(file, Charsets.UTF_8)
                .write("hello");
        // 读文件
        log.info(Files.readLines(file, Charsets.UTF_8).toString());
        // 追加文件
        Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND)
                .write("world");
        // 读文件
        log.info(Files.readLines(file, Charsets.UTF_8).toString());
    }
}
