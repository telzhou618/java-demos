package com.example.apache.io;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;

/**
 * FilenameUtils demo
 *
 * @author zhougaojun
 */
@Slf4j
public class FileNameUtilMain extends FilenameUtils {

    public static void main(String[] args) {
        String fileName = "/tmp/aaa/bbb/ccc.txt";
        // 文件名称不带后缀,ccc
        System.out.println(getBaseName(fileName));
        // 文件名带后缀,ccc.txt
        System.out.println(getName(fileName));
        // 文件后缀,txt
        System.out.println(getExtension(fileName));
        // /tmp/aaa/bbb/
        System.out.println(getFullPath(fileName));
        // tmp/aaa/bbb/
        System.out.println(getPath(fileName));
        // 删除后缀,/tmp/aaa/bbb/ccc
        System.out.println(removeExtension(fileName));
    }
}
