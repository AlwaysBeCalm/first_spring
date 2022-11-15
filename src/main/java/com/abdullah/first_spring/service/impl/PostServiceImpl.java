package com.abdullah.first_spring.service.impl;

import com.abdullah.first_spring.dto.PostDto;
import com.abdullah.first_spring.entity.Post;
import com.abdullah.first_spring.mapper.PostMapper;
import com.abdullah.first_spring.repository.PostRepo;
import com.abdullah.first_spring.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<PostDto> findAllPosts() {
        List<Post> posts = postRepo.findAll();
        /*
        converting from List of Post to List of PostDto using Lambda Expression.
        posts.stream().map(
            (post) -> PostMapper.mapToPostDto(post)
        ).collect(Collectors.toList());
        */
        return posts.stream().map(
                // here using Method Reference
                PostMapper::mapToPostDto
        ).collect(Collectors.toList());
    }
}
