package com.example.strategy;

public class HashStrategyProxy implements HashStrategy {

    private HashStrategy hashStrategy;
    private String prex;

    public HashStrategyProxy(HashStrategy hashStrategy, String prex) {
        this.hashStrategy = hashStrategy;
        this.prex = prex;
    }

    @Override
    public String hash(String str) {
        return hashStrategy.hash(prex + str);
    }
}
