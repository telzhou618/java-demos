package com.example.queue;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhougaojun
 * @since 2021/9/3
 * 从队列一条条取数据，取完自动查询数源数据，再一条条取，如此反复操作。
 */
public class QueueMain {

    public interface DataHandler {
        Queue<User> handler();
    }

    @Getter
    @Setter
    @ToString
    public static class User {

        private Integer userId;
        public User(Integer userId) {
            this.userId = userId;
        }
    }

    public static class TimelineQueue {

        private final Queue<User> data;
        private final DataHandler dataHandler;

        public TimelineQueue(DataHandler dataHandler) {
            data = new LinkedList<>();
            this.dataHandler = dataHandler;
        }

        public User poll() {
            if (data.isEmpty()) {
                data.addAll(dataHandler.handler());
            }
            return data.poll();
        }
    }

    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler() {
            @Override
            public Queue<User> handler() {
                System.out.println("远程查询数据");
                LinkedList<User> list = new LinkedList<>();
                list.add(new User(1));
                list.add(new User(2));
                list.add(new User(3));
                return list;
            }
        };
        TimelineQueue timelineQueue = new TimelineQueue(dataHandler);
        while (true) {
            System.out.println(timelineQueue.poll());
        }
    }
}
