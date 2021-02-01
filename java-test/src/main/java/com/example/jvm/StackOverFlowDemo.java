package com.example.jvm;

import lombok.Data;

/**  StackOverflowError demo
 * @author zhougaojun
 */
public class StackOverFlowDemo {

    /**
     * 无限递归会报栈溢出
     */
    public static void foo(){
        System.out.println("foo");
        foo();
    }

    @Data
    public static class  A{
        private B b;
    }
    @Data
    public static class  B{
        private A a;
    }

    public static void main(String[] args) {
        // 无限递归调用  StackOverflowError
        // foo();

        // 互相依赖，调用toString StackOverflowError
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);
        System.out.println(a);
    }
}
