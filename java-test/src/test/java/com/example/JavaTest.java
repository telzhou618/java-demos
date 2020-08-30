package com.example;

import org.junit.Test;

/**
 * @author jameszhou
 */
public class JavaTest {

    @Test
    public void test1() {
        String s1 = "test";
        String s2 = s1 + 1;
        String s3 = s1 + 1;
        System.out.println(s2 == s3);
    }

    @Test
    public void test2() {
       /* System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(1 << 1));
        System.out.println(Integer.toBinaryString(1 << 1));
        System.out.println(Integer.toBinaryString(1 << 2));
        System.out.println(Integer.toBinaryString(1 << 3));
        System.out.println(Integer.toBinaryString(1 << 31));*/
//        System.out.println(Integer.toBinaryString(1));
//        System.out.println(Integer.toBinaryString(~1));
//        System.out.println(Integer.toBinaryString(1 & ~1));
//        System.out.println(Integer.toBinaryString(1 & 1));/**/

        int add = 1;
        int del = 1 << 1;
        int update = 1 << 2;
        int get = 1 << 3;

        int admin = add + del + update + get;
        int keeper = add  + update + get;

        System.out.println((admin & add) == add);
        System.out.println((admin & del) == del);
        System.out.println((keeper & del) == del);

        keeper = keeper + del;

        System.out.println((keeper & del) == del);

//        keeper = keeper - del;
//        System.out.println((keeper & del) == del);

         keeper = keeper & ~ del;
        System.out.println((keeper & del) == del);


    }

    @Test
    public void test3() {
        int add = 1;
        int del = add << 1;
        int update = add << 2;
        int get = add << 3;
        int other = add << 31;
        int other1 = add << 32;
        System.out.println(Integer.toBinaryString(add));
        System.out.println(Integer.toBinaryString(del));
        System.out.println(Integer.toBinaryString(update));
        System.out.println(Integer.toBinaryString(get));
        System.out.println(Integer.toBinaryString(other));
        System.out.println(Integer.toBinaryString(other1));
    }

    @Test
    public void test4() {
        long add = 1;
        long del = add << 1;
        long update = add << 2;
        long get = add << 3;
        long other = add << 63;
        long other1 = add << 64;
        System.out.println(Long.toBinaryString(add));
        System.out.println(Long.toBinaryString(del));
        System.out.println(Long.toBinaryString(update));
        System.out.println(Long.toBinaryString(get));
        System.out.println(Long.toBinaryString(other));
        System.out.println(Long.toBinaryString(other1));
    }
}
