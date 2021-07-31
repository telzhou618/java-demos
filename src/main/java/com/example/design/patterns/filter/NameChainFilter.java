package com.example.design.patterns.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhougaojun
 */
public class NameChainFilter implements ChainFilter<User> {

    @Override
    public List<User> doFilter(List<User> data) {
        return data.stream().filter(o -> o.getName().contains("zhou")).collect(Collectors.toList());
    }
}
