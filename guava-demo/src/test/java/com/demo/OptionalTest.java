package com.demo;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Optional 类使用
 *
 * @author jameszhou
 */
public class OptionalTest {

    @Test
    public void test() {

        /**
         * 输出1，不能接受null值
         */
        System.out.println(Optional.of(1).get());
        /**
         * 输出1，能接受null值
         */
        System.out.println(Optional.fromNullable(1).get());
        /**
         * 输出默认值1，能接受null值
         */
        System.out.println(Optional.fromNullable(null).or(1));
        /**
         *  判断之是否为null
         */
        System.out.println(Optional.fromNullable(1).isPresent());
        /**
         * 职位null时返回Null
         */
        System.out.println(Optional.fromNullable(null).orNull());
        /**
         * 转为 set,只有一个元素
         */
        System.out.println(Optional.fromNullable(1).asSet());
        /**
         * 报错, NullPointerException
         */
        System.out.println(Optional.of(null));
    }
}
