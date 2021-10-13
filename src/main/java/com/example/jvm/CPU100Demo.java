package com.example.jvm;

import java.util.Random;

/**  模拟CPU100%
 * @author zhougaojun
 * @since 2021/10/9
 */
public class CPU100Demo {

    public static int testAdd(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        while (true) {
            Random random = new Random();
            while (true) {
                testAdd(random.nextInt(), random.nextInt());
            }
        }
    }
}
