package com.example.jvm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author zhougaojun
 * @since 2021/10/13
 */
public class JvmDemo {

    private final static Object o1 = new Object();
    private final static Object o2 = new Object();
    private final static List<String> list = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        deadLock();
        memoryHigh();
        traceCallChain();
        cpu100();
    }

    public static void deadLock() {
        System.out.println("deadLock run...");
        new Thread(() -> {
            synchronized (o1) {
                try {
                    System.out.println("thead1,begin");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("thead1,end");
                }
            }

        }).start();

        new Thread(() -> {
            synchronized (o2) {
                try {
                    System.out.println("thead2,begin");
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("thead2,end");
                }
            }
        }).start();
    }

    public static void cpu100() {
        System.out.println("cpu100 run...");
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                addTest(random.nextInt(), random.nextInt());
            }
        }, "thead-cpu100").start();
    }

    public static void memoryHigh() {
        System.out.println("memoryHigh run...");
        new Thread(() -> {
            Random random = new Random();
            while (true) {
                String s = String.valueOf(random.nextLong());
                list.add(s);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thead-memoryHigh").start();

    }


    public static int addTest(int a, int b) {
        return a + b;
    }

    public static void traceCallChain() {
        System.out.println("traceCallChain run...");
        new Thread(() -> {
            while (true){
                test1();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void test3() {
        test4();
        test5();
    }

    private static void test5() {
        test6();
    }

    private static void test6() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test4() {
    }

    private static void test2() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        test2();
        test3();
    }

}
