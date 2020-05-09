package com.demo;

import com.google.common.base.Charsets;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * 文件操作
 *
 * @author jameszhou
 */
@Slf4j
public class FilesTest {

    /**
     * 文件创建和读取
     *
     * @throws Exception
     */
    @Test
    public void test() throws Exception {
        File file = new File("/tmp/test.txt");
        Files.touch(file);
        log.info(file.getAbsolutePath());
        // 写文件
        Files.asCharSink(file, Charsets.UTF_8).write("hello");
        // 读文件
        log.info(Files.readLines(file, Charsets.UTF_8).toString());
        // 追加文件
        Files.asCharSink(file, Charsets.UTF_8, FileWriteMode.APPEND).write("world");
        // 读文件
        log.info(Files.readLines(file, Charsets.UTF_8).toString());
        log.info("文件是否存在:" + file.exists());
        // 删除文件
        file.delete();
        log.info("文件是否存在:" + file.exists());
    }

    /**
     * 文件移动
     * @throws Exception
     */
    @Test
    public void testMove() throws Exception {
        File file = new File("/tmp/test.txt");
        Files.touch(file);
        Files.asCharSink(file, Charsets.UTF_8).write("hello");

        File toFile = new File("/tmp/test/test.txt");
        Files.move(file, toFile);
        System.out.println(Files.readLines(toFile, StandardCharsets.UTF_8).toString());
    }

    /**
     * 文件拷贝
     * @throws Exception
     */
    @Test
    public void testCopy() throws Exception {
        File file = new File("/tmp/test.txt");
        Files.touch(file);
        Files.asCharSink(file, StandardCharsets.UTF_8).write("copy");

        File toFile = new File("/tmp/test/test.txt");
        Files.copy(file, toFile);
        System.out.println(Files.readLines(toFile, StandardCharsets.UTF_8).toString());
    }
}
