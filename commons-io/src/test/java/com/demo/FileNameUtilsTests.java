package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

/**
 * FilenameUtils demo
 *
 * @author zhougaojun
 */
@Slf4j
public class FileNameUtilsTests extends FilenameUtils {

    @Test
    public void test() {
        String fileName = "/tmp/aaa/bbb/ccc.txt";
        // 文件名称不带后缀,ccc
        log.info(getBaseName(fileName));
        // 文件名带后缀,ccc.txt
        log.info(getName(fileName));
        // 文件后缀,txt
        log.info(getExtension(fileName));
        // /tmp/aaa/bbb/
        log.info(getFullPath(fileName));
        // tmp/aaa/bbb/
        log.info(getPath(fileName));
        // 删除后缀,/tmp/aaa/bbb/ccc
        log.info(removeExtension(fileName));
    }
}
