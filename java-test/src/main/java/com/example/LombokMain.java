package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhougaojun
 */
public class LombokMain {

    enum ME{A,B,C}

    public static void main(String[] args) {

        Map<ME,Object> map =new HashMap<>();
        map.put(ME.A,123);
        map.put(ME.B,1234);
        System.out.println(map.get(ME.A));
        System.out.println(map.get(ME.B));
    }
}
