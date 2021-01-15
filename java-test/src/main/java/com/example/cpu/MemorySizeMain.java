/**
 * @author zhougaojun
 */
package com.example.cpu;

/**
 * @author gaojun.zhou
 */

public class MemorySizeMain {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();

        System.out.println("堆内存的初始值" + totalMemory / 1024 + "kb");
        System.out.println("堆内存的最大值" + maxMemory / 1024 + "kb");
    }
}
