package com.example.design.patterns.singleton;

/**
 * @author jameszhou
 */
public class DoubleCheckLockSingletonService {

    private static volatile DoubleCheckLockSingletonService INSTANCE;

    private DoubleCheckLockSingletonService() {
        System.out.println("实例化");
    }

    public static DoubleCheckLockSingletonService getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLockSingletonService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLockSingletonService();
                }
            }
        }
        return INSTANCE;
    }
}
