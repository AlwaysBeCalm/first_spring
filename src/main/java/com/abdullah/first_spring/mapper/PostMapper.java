package com.abdullah.first_spring.mapper;

import com.abdullah.first_spring.dto.PostDto;
import com.abdullah.first_spring.entity.Post;

public class PostMapper {
    // map post entity to PostDto
    public static PostDto mapToPostDto(Post post){

        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .url(post.getUrl())
                .shortDesc(post.getShortDesc())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .build();
    }

    public static Post mapToPost(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .shortDesc(postDto.getShortDesc())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();
    }
}
