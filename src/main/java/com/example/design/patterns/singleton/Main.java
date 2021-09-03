package com.example.design.patterns.singleton;

/**
 * @author jameszhou
 */
public class Main {

    public static void main(String[] args) {

        // 双重检查锁单例
        System.out.println(DoubleCheckLockSingletonService.getInstance());
        System.out.println(DoubleCheckLockSingletonService.getInstance());

        // 内部类单例模式
        // 外部内加载时不会立即加载内部类，也不会实例化内部类，只有在使用是加载一次，所以次中方式在不适用单例对象时不占用空间。
        System.out.println(InnerSingletonService.getInstance());
        System.out.println(InnerSingletonService.getInstance());
    }
}
