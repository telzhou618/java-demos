package com.example.filter;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author zhougaojun
 */
public class Main3 {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User().setId(1).setAge(12).setName("zhougaojun"));
        userList.add(new User().setId(2).setAge(8).setName("lisi"));
        userList.add(new User().setId(3).setAge(18).setName("zhangsan"));
        userList.add(new User().setId(4).setAge(11).setName("zhoutao"));

        Context context = new Context(1);

        userList.stream()
                .filter(ageFilter)
                .filter(nameFilter)
                .filter(o -> contextFilter(o,context))
                .forEach(System.out::println);
    }

    private static Predicate<User> ageFilter = o -> o.getAge() > 10;
    private static Predicate<User> nameFilter = o -> o.getName().contains("zhou");


    private static boolean contextFilter(User user,Context context){
        return context.getFollowUserIds().contains(user.getId());
    }


    private static class Context {
        private int userId;
        private List<Integer> followUserIds;


        public Context(Integer userId) {
            this.userId = userId;
        }

        public List<Integer> getFollowUserIds() {
            System.out.println("得到我关注的用户ID列表");
            if (this.followUserIds == null) {
                this.followUserIds = getMyFollowUserIds(this.userId);
            }
            return this.followUserIds;
        }
    }

    private static List<Integer> getMyFollowUserIds(Integer userId) {
        System.out.println("真实SQL查询我关注的用户ID列表");
        return Lists.newArrayList(1, 2, 4);
    }
}
