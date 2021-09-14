package com.example.concurrent.time;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhougaojun
 * @since 2021/9/13
 */
public class ScheduledExecutorServiceMain {

    private final static ScheduledExecutorService EXECUTOR = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) throws InterruptedException {
        EXECUTOR.scheduleAtFixedRate(() ->{
            System.out.println(Thread.currentThread().getName() + ": 1");
        }, 1000 , 1000, TimeUnit.MILLISECONDS);

        TimeUnit.HOURS.sleep(1);
    }
}
