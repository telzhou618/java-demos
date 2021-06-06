package com.example.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhougaojun
 */
public class AgeChainFilter implements ChainFilter<User> {

    @Override
    public List<User> doFilter(List<User> data) {
        return data.stream().filter(o -> o.getAge() > 10).collect(Collectors.toList());
    }
}
