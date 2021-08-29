package com.example.design.patterns.singleton;

/**
 * @author jameszhou
 */
public class InnerSingletonService {


    private InnerSingletonService() {
        System.out.println("实例化");
    }

    public static InnerSingletonService getInstance() {
        return InnerSingletonServiceInnerClass.INSTANCE;
    }

    private static class InnerSingletonServiceInnerClass {

        private static InnerSingletonService INSTANCE = new InnerSingletonService();
    }
}
