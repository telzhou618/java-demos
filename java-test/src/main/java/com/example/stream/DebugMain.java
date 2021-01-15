
package com.example.stream;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zhougaojun
 */

public class DebugMain {

    public static void main(String[] args) {

        // 1.Stream 调试
        List<Integer> list1 = Lists.newArrayList(1, 5, 3, 2, 4);
        List<Integer> list2 = list1.stream()
                .filter(o -> o > 2)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list2);


        // 2.Optional 调试
        User user = new User()
                .setId(1)
                .setName("tom")
                .setArea(new Area().setProvince("beijing"));

        String province = Optional.ofNullable(user)
                .map(User::getArea)
                .map(Area::getProvince)
                .orElse("未知");
        System.out.println(province);

        // 3.条件断点, 循环
        List<Integer> integerList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer x : integerList) {
            System.out.print(x);
        }

        // 4.多线程调试
        new Thread(() -> {
            System.out.println("线程1执行");
        }, "线程1").start();

        new Thread(() -> {
            System.out.println("线程2执行");
        }, "线程2").start();

        System.out.println("主线程");

        // 5.方法回退, 回退到上一步
        method1();

        // 6. 强制返回
        int c = compute(1, 2);
        System.out.println(c);

        // 7. 运行过程修改变量的值
        int a = 1;
        System.out.println(a);



    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class User {
        private Integer id;
        private String name;
        private Area area;
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Area {
        private String province;
    }

    public static void method1() {
        System.out.println("method1");
        method2();
    }

    public static void method2() {
        System.out.println("method2");
        method3();
    }

    public static void method3() {
        System.out.println("method3");
    }

    public static int compute(int x, int y) {
        System.out.println(x);
        System.out.println(y);
        return x + y;
    }
}
