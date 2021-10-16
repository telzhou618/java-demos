package com.example.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhougaojun
 * @since 2021/10/16
 */
public class ReentrantLockMain {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> test2(), "th-1").start();
        new Thread(() -> test2(), "th-2").start();
        new Thread(() -> test2(), "th-3").start();
    }

    /**
     * 以此等待执行
     */
    private static void test1() {
        lock.lock();
        try {
            // 执行业务逻辑
            System.out.println("执行业务逻辑，threadName = " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 获取锁失败，立即返回
     */
    private static void test2()  {
        try {
            if (lock.tryLock(1200, TimeUnit.MILLISECONDS)) {
                //if (lock.tryLock()) {
                try {
                    // 执行业务逻辑
                    System.out.println("执行业务逻辑,threadName=" + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("获取锁帖失败,threadName=" + Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            System.out.println("锁中断");
        }

    }
}
