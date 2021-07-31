package com.example.design.patterns.filter;

import java.util.List;

/**
 * @author zhougaojun
 */
public interface ChainFilter<T> {

    List<T> doFilter(List<T> data);
}
