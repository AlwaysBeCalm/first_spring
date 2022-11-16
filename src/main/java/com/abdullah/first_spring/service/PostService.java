package com.abdullah.first_spring.service;

import com.abdullah.first_spring.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

    void createPost(PostDto postDto);
}
