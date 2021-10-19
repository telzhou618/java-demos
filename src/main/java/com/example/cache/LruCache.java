package com.example.cache;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zhougaojun
 * @since 2021/10/19
 */
public class LruCache {

    private int capacity; // 容量
    private Map<String, Object> cacheMap; // 缓存数据 key-val
    private Map<String, String> keyMap;
    private String eldestKey;

    public LruCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(capacity);

        //  利用 LinkedHashMap 的 removeEldestEntry 方法实现LRU
        keyMap = new LinkedHashMap<String, String>(capacity, .75F, true) {
            // 为 true 删除最最近最久未使用的key
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                boolean bool = size() > capacity; // 判断是否超过容量
                if (bool) {
                    System.out.println("容量不足，淘汰数据,key=" + eldest.getKey());
                    eldestKey = eldest.getKey();
                }
                return bool;
            }
        };
    }

    public Object get(String key) {
        keyMap.get(key); // touch
        return cacheMap.get(key);
    }

    public void put(String key, Object value) {
        cacheMap.put(key, value);
        removeEldestKey(key);
    }

    private void removeEldestKey(String key) {
        keyMap.put(key, key);
        if (eldestKey != null) {
            cacheMap.remove(eldestKey);
            eldestKey = null;
        }
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(2);

        lruCache.put("k1", "v1");
        lruCache.put("k2", "v2");
        lruCache.put("k3", "v3");   // 此时会触发淘汰策略

        System.out.println(lruCache.get("k1"));
        System.out.println(lruCache.get("k2"));
        System.out.println(lruCache.get("k3"));
    }
}
