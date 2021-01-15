package com.example.cpu;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author zhougaojun
 */
public class ObjectSizeMain {

    public static void main(String[] args) {
        byte[] bytes = new byte[1000];
        System.out.println(ClassLayout.parseInstance(bytes).toPrintable());
    }
}
