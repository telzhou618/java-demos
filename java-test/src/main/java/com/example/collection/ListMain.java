/**
 * @author zhougaojun
 */
package com.example.collection;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author gaojun.zhou
 */

public class ListMain {

    public static Object object = new Object();

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1);
        list.add(1, 1);
        System.out.println(list);

        for (int i = 0; i < 10; i++) {
            synchronized (object) {
                // do something
            }
        }

        int i = 0;   //1   原子操作,对基本数据类型的变量和赋值操作都是原子性操作；
        int j = i;   //2   非原子操作,中包含了两个操作：读取i，将i值赋值给j
        i++;         //3   非原子操作,读取i值、i + 1 、将+1结果赋值给i；
        i = j + 1;   //4   非原子操作,同3一样


    }

    // 线程1执行的代码
   volatile int i = 0;

    public  void main2(String[] args) {
        i = 10;
    }
    public  void main3(String[] args) {


        int a = 10;   //语句1
        int r = 2;    //语句2
        a = a + 3;    //语句3
        r = a*a;      //语句

    }

}
