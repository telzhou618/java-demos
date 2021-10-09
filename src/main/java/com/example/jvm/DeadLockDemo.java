package com.example.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @author zhougaojun
 * @since 2021/10/9
 */
public class DeadLockDemo {

    private final static Object o1 = new Object();
    private final static Object o2 = new Object();

    public static void main(String[] args) {

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
}
