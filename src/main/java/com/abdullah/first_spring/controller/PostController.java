package com.abdullah.first_spring.controller;

import com.abdullah.first_spring.dto.PostDto;
import com.abdullah.first_spring.service.PostService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/admin/posts")
    public String createPost(@Valid // to validate the incoming data from the form
                             @ModelAttribute PostDto postDto,  // the model attribute which been passed to the form and being validated
                             BindingResult bindingResult,
                             Model model
    ) {
        if (bindingResult.hasErrors()){
            model.addAttribute("postDto", postDto);
            return "admin/new-post";
        }
        postDto.setUrl(PostController.getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/admin/posts";
    }

    private static String getUrl(String postTitle) {
        // e.g. post title is: Post About Java
        // then the post url will be /posts/post-about-java

        String title = postTitle.trim().toLowerCase().replaceAll("\\s+", "-");
        return title.replaceAll("[^A-Za-z0-9]", "-");
    }
}
