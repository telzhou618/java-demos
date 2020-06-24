package com.example.strategy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jameszhou
 */
@Setter
@Getter
public class Context {

    private HashStrategy hashStrategy;

    public Context(HashStrategy hashStrategy) {
        this.hashStrategy = hashStrategy;
    }

    public String hash(String str) {

        if (str == null || str.isEmpty()) {
            throw new RuntimeException("str = " + str + ",but it is not blank!");
        }
        return hashStrategy.hash(str);
    }
}
