package com.abdullah.first_spring.controller;

import com.abdullah.first_spring.dto.PostDto;
import com.abdullah.first_spring.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create handler method for GET request and return model and view
    @GetMapping("/admin/posts")
    public String posts(Model model) { // try to remove the model param
        List<PostDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }

//    @RequestMapping(
//            name = "/admin/new-post",
//            method = {RequestMethod.GET, RequestMethod.POST}
//    )
    @GetMapping("/admin/posts/new-post")
    public String newPostForm(Model model) {
        PostDto postDto = new PostDto();
        model.addAttribute("postDto", postDto);
        return "admin/new-post";
    }
}
