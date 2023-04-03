package com.example.stream;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureMain {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() ->{
            System.out.println(Thread.currentThread().getName() + "：子线程支持");
            return "hello";
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            return null;
        });

        System.out.println("哈哈哈");
    }
}
