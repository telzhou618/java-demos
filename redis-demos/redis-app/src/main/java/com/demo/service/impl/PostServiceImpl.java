package com.demo.service.impl;

import com.demo.entitry.Post;
import com.demo.repository.PostRepository;
import com.demo.service.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: zhougaojun
 * @date: 2019/05/21
 * @description:
 */
@Service
public class PostServiceImpl implements PostService {
    @Resource
    private PostRepository postRepository;

    @Override
    public List<Post> getPostTopByVotes(int num) {
        return postRepository.findTopByVotes(num);
    }
}
