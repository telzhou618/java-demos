package com.example;

import com.carrotsearch.sizeof.RamUsageEstimator;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author jameszhou
 */
public class ObjectSizeTest {

    @Data
    @AllArgsConstructor
    class A {
        private Integer id;
        private Double total;
    }

    @Test
    public void test6() {

        //打印实例的内存布局
        System.out.println(ClassLayout.parseInstance(new A(1, 10D)).toPrintable());
        //打印对象的所有相关内存占用
        System.out.println(GraphLayout.parseInstance(new A(1, 10D)).toPrintable());
        //打印对象的所有内存结果并统计
        System.out.println(GraphLayout.parseInstance(new A(1, 10D)).toFootprint());
    }

    @Data
    @AllArgsConstructor
    class BoardPost {
        private Integer postId;
        private Integer boardId;
        private Date postTime;
    }

    @Test
    public void test7() {
        List<BoardPost> boardPostList = new ArrayList<>(2000);
        for (int i = 0; i < 2000; i++) {
            boardPostList.add(new BoardPost(111111112, 222, new Date()));
        }
        //打印实例的内存布局
        System.out.println(ClassLayout.parseInstance(boardPostList).toPrintable());
    }


    @Test
    public void test8() {
        List<BoardPost> boardPostList = new ArrayList<>(2000);
        for (int i = 0; i < 2000; i++) {
            boardPostList.add(new BoardPost(111111112, 222, new Date()));
        }
        System.out.println(RamUsageEstimator.sizeOf(boardPostList));
    }
}
