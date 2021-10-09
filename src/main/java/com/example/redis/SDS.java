package com.example.redis;

/**
 * @author zhougaojun
 * @since 2021/9/14
 */
public class SDS {
    /**
     * len
     */
    private long len;
    /**
     * free length
     */
    private long free;
    /**
     * store string buff
     */
    private char[] buf;
}
