package com.dxy;

import com.dxy.entitry.User;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhougaojun
 * @date: 2019/05/24
 * @description:
 */
public class UserTest extends SpringBootTests {

    /**
     * 所有用户
     */
    public static final List<User> users = Lists.newArrayList(
            new User(1, "zhangsan", 5),
            new User(2, "lisi", 10),
            new User(3, "wangwu", 3),
            new User(4, "zhaoliu", 34),
            new User(5, "maqi", 22)
    );
    /**
     * 张三的好友
     */
    public static final List<String> zhangSanFriends = Lists.newArrayList("lisi", "wangwu", "zhaoliu");
    /**
     * 李四的好友
     */
    public static final List<String> lisiFriends = Lists.newArrayList("wangwu", "zhaoliu", "maqi");

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @Test
    public void init() {
        users.stream().forEach(user -> {
            redisTemplate.opsForZSet().add("users", user, user.getVotes());
        });

        zhangSanFriends.stream().forEach(id -> {
            redisTemplate.opsForZSet().add("zhangSanFriends", id, 0);
        });

        lisiFriends.stream().forEach(id -> {
            redisTemplate.opsForZSet().add("lisiFriends", id, 0);
        });
    }
}
