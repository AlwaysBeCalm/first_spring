package com.abdullah.first_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/")
    public String redirectToPosts() {
        return "redirect:/admin/posts";
    }
}
