package com.example;

import com.example.model.Cat;
import lombok.var;
import org.junit.Test;

/**
 * @author zhougaojun
 */
public class LombokTest {

    @Test
    public void test() {
        var a = 10;
        System.out.println(10);
        System.out.println(Long.MAX_VALUE);
    }

    @Test
    public void test2() {
        Cat cat = new Cat();
        cat.setColor("black");
        cat.setName("cat");
        System.out.println(cat);
    }
}
