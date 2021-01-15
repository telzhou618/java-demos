/**
 * @author zhougaojun
 */
package com.example.concurrent.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gaojun.zhou
 * @date 2020/12/23
 */

public class AtomicIntegerMain {

    //  AtomicInteger atomicInteger = new AtomicInteger();


    public static void main(String[] args) throws InterruptedException {
        //
        AtomicInteger longAdder = new AtomicInteger();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                longAdder.incrementAndGet();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                longAdder.incrementAndGet();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(longAdder.intValue());
    }
}
