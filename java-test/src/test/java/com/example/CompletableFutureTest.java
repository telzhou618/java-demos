package com.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CompletableFutureTest {

    Executor executor = Executors.newFixedThreadPool(5);

    public void sleep(long time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 三个任务并行执行
     */
    @Test
    public void test1() {

        CompletableFuture f1 = CompletableFuture.runAsync(() -> {
            log.info("任务1开始执行");
            sleep(1);
            log.info("任务1执行完成");
        }, executor);
        CompletableFuture f2 = CompletableFuture.runAsync(() -> {
            log.info("任务2开始执行");
            sleep(2);
            log.info("任务2执行完成");
        }, executor);
        CompletableFuture f3 = CompletableFuture.runAsync(() -> {
            log.info("任务3开始执行");
            sleep(3);
            log.info("任务3执行完成");
        }, executor);

        CompletableFuture.allOf(f1, f2, f3);
        sleep(5);
    }


    /**
     * 任务1,任务2并行执行，任务3需要等到任务1,2执行完成再执行
     */
    @Test
    public void test2() {

        CompletableFuture f1 = CompletableFuture.supplyAsync(() -> {
            log.info("任务1");
            sleep(1);
            return "任务1结果";
        }, executor);

        CompletableFuture f2 = CompletableFuture.supplyAsync(() -> {
            log.info("任务2");
            sleep(2);
            return "任务2结果";
        }, executor);

        CompletableFuture f3 = f1.thenCombine(f2, (t1, t2) -> {
            String t3 = t1.toString() + "," + t2.toString() + ",任务3结果";
            sleep(3);
            return t3;
        });
        System.out.println(f3.join());
    }
}
