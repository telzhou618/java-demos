package com.example.jvm;

import java.util.ArrayList;
import java.util.List;

/** 内存溢出
 * VM Args：-Xms8m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=path
 * -XX:+HeapDumpOnOutOfMemoryError 表示内存溢出dump当前线程的快照
 * -XX:HeapDumpPath=path 内存溢出前保存堆栈信息日志
 *
 * @author zhougaojun
 */
public class HeapOOMDemo {
    public static class OOMObject {
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
            System.out.println("添加元素成功");
        }
    }
}
