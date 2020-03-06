package com.example.demo.service;

/**
 * @author zhougaojun
 */
public class UserSingleton {

    private static UserSingleton userSingleton;

    /**
     * 性能高的单例模式
     * @return
     */
    public static UserSingleton getInstance() {
        if (userSingleton == null) {
            synchronized (UserSingleton.class) {
                if (userSingleton == null) {
                    userSingleton = new UserSingleton();
                }
            }
        }
        return userSingleton;
    }

    /**
     * 性能差的单例模式
     * @return
     */
    public static UserSingleton getInstance2() {
        synchronized (UserSingleton.class) {
            if (userSingleton == null) {
                userSingleton = new UserSingleton();
            }
            return userSingleton;
        }
    }

    public UserSingleton() {
        System.out.println("实例化");
    }
}
