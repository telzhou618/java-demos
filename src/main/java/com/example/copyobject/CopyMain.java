package com.example.copyobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author zhougaojun
 * @since 2021/9/3
 */
public class CopyMain {


    @Getter
    @Setter
    @ToString
    @Accessors(chain = true)
    public static class User implements Cloneable {
        private Integer userId;

        /**
         * 浅拷贝
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    @Getter
    @Setter
    @ToString
    @Accessors(chain = true)
    public static class Post implements Cloneable {
        private int id;
        private String title;
        private User user;

        /**
         * 深拷贝, 对应引用类的对象
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Post newPost = (Post) super.clone();
            newPost.setUser((User) user.clone());
            return newPost;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        // 浅拷贝
        User u1 = new User().setUserId(1);
        User u2 = (User) u1.clone();
        u2.setUserId(2);
        System.out.println(u1);
        System.out.println(u2);

        System.out.println("------");
        // 深拷贝
        Post post = new Post().setTitle("111").setId(1).setUser(new User().setUserId(1));
        Post post1 = (Post) post.clone();
        post1.setId(2).setTitle("222");
        post1.getUser().setUserId(2);

        System.out.println(post);
        System.out.println(post1);
    }
}
