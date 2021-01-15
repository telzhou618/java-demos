/**
 * @author zhougaojun
 */
package com.example.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gaojun.zhou
 * @date 2020/12/03
 */

public class ThreadMain {

    static class ThreadItem extends Thread {

        public ThreadItem() {
        }

        public ThreadItem(String name) {
            super(name);
        }

        @SneakyThrows
        @Override
        public void run() {
            System.out.println("线程休眠30秒");
            Thread.sleep(30000);
            System.out.println("线程开始执行");
            int i = 0;
            while (i < 5000000) {
                i++;
                System.out.println(i);
            }
            System.out.println("线程休眠20秒");
            Thread.sleep(20000);
            System.out.println("线程继续执行");
            int j = 0;
            while (j < 2000000) {
                j++;
                System.out.println(i);
            }
            System.out.println("线程执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger i = new AtomicInteger(1);
        while (true) {
            new ThreadItem("my-thread-" + i.getAndIncrement()).start();
            Thread.sleep(30000);
        }
    }
}
