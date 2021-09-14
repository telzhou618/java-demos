package com.example.concurrent.time;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author zhougaojun
 * @since 2021/9/13
 */
public class TimeMain {

    private final static Timer timer = new Timer("ServerHouseKeepingService", true);

    public static void main(String[] args) throws InterruptedException {

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":111");
            }
        }, 3000, 1000);

        System.out.println("hahahha");

        TimeUnit.HOURS.sleep(1);
    }
}
