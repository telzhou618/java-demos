package com.example.jvm;

/**
 * @author zhougaojun
 * @since 2021/10/9
 */
public class CPU100Demo {

    public static int  test() {
        return 1 + 1;
    }

    public static void main(String[] args) {
        while (true) {
            test();
        }
    }
}
