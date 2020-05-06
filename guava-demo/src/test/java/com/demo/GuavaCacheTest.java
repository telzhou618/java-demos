package com.demo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * guava 缓存操作
 *
 * @author jameszhou
 */
public class GuavaCacheTest {

    /**
     * 缓存定义
     */
    LoadingCache<Integer, String> userNameCache = CacheBuilder.newBuilder()
            /**
             * expireAfterWrite 是指缓存在指定时间没有被新的值覆盖时，将失效。
             * expireAfterAccess 是指缓存在指定时间没有被读写时，将失效。
             * refreshAfterWrite是在指定时间内没有被创建/覆盖，则指定时间过后，再次访问时，会去刷新该缓存，在新值没有到来之前，始终返回旧值
             */
            .expireAfterAccess(3, TimeUnit.SECONDS) // 缓存时间3秒，3没有被读取失效
            .build(new CacheLoader<Integer, String>() {
                @Override
                public String load(Integer id) throws Exception {
                    String userName = id + "_UserName";
                    System.out.println("从数据库获取：" + userName);
                    return userName;
                }
            });

    @Test
    public void test() {
        System.out.println(userNameCache.getUnchecked(1)); // 第一次请求从数据库获取
        System.out.println(userNameCache.getUnchecked(1)); // 第二次请求从缓存中获取

        System.out.println(userNameCache.getUnchecked(2));
        System.out.println(userNameCache.getUnchecked(2));
    }
}
