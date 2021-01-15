/**
 * @author zhougaojun
 */
package com.example.concurrent.cas;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author gaojun.zhou
 * @date 2020/12/23
 */

public class LongAdderMain {


    public static void main(String[] args) throws InterruptedException {
        // LongAdder 时候高并发、写多读少，最后再合计的场景。
        LongAdder longAdder = new LongAdder();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                longAdder.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                longAdder.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(longAdder.intValue());
    }
}
