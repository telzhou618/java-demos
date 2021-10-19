package com.example.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zhougaojun
 * @since 2021/10/19
 */
public class LfuCache {

    private int capacity; // 容量
    private Map<String, Object> cacheMap; // 缓存数据 key-val
    private Map<String, Integer> keyMap;  // 缓存key和命中次数，用于当容量不足时删除访问次数最少的key

    public LfuCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>(this.capacity);
        keyMap = new HashMap<>(this.capacity);
    }

    public Object get(String key) {
        touchKey(key);
        return cacheMap.get(key);
    }

    public void put(String key, Object value) {
        cacheMap.put(key, value);
        clearExpireKeys();
    }

    /**
     * 记录key的访问次数
     * @param key
     */
    private void touchKey(String key) {
        if (keyMap.containsKey(key)) {
            keyMap.put(key, keyMap.get(key) + 1);
        } else {
            keyMap.put(key, 1);
        }
    }

    /**
     * 删除访问次数最少的key(找出key的访问次数最少的那个对象，删除)
     */
    private void clearExpireKeys() {
        if (cacheMap.size() > this.capacity) {
            Set<Map.Entry<String, Integer>> entries = keyMap.entrySet();
            // 找出value最小的key
            Map.Entry<String, Integer> entry0 = null;
            for (Map.Entry<String, Integer> entry : entries) {
                if (entry0 == null) {
                    entry0 = entry;
                }
                if (entry0.getValue() > entry.getValue()) {
                    entry0 = entry;
                }
            }

            if (entry0 != null) {
                keyMap.remove(entry0.getKey());
                cacheMap.remove(entry0.getKey());
            }
        }
    }

    public static void main(String[] args) {
        // 容量3
        LfuCache lfuCache = new LfuCache(3);
        // put 现在存三个值
        lfuCache.put("k1","v1");
        lfuCache.put("k2","v2");
        lfuCache.put("k3","v3");

        // get
        lfuCache.get("k1"); // k1 访问2次
        lfuCache.get("k1");
        lfuCache.get("k2"); // k2 访问1次
        lfuCache.get("k3"); // k3访问3次
        lfuCache.get("k3");
        lfuCache.get("k3");

        // 插入k4, 会淘汰k2
        lfuCache.put("k4","v4");

        System.out.println(lfuCache.get("k1"));
        System.out.println(lfuCache.get("k2")); // null
        System.out.println(lfuCache.get("k3"));
        System.out.println(lfuCache.get("k4"));
    }
}
