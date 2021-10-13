package com.example.jvm;

/**
 * Arthas 调用链耗时监控
 *
 * @author zhougaojun
 * @since 2021/10/13
 */
public class TraceCallChain {

    public static void main(String[] args) {
        System.out.println("traceCallChain run...");
        while (true) {
            test();
        }
    }

    private static void test() {
        test1();
        test2();
        test3();
        test4();
    }


    private static void test1() {
        sleep(200);
    }

    private static void test2() {
        sleep(50);
    }

    private static void test3() {
        test31();
        test32();
    }


    private static void test31() {
        sleep(2000);
    }

    private static void test32() {
        sleep(100);
    }

    private static void test4() {
        sleep(300);
    }

    public static void sleep(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
