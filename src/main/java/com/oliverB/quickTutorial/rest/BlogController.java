package com.oliverB.quickTutorial.rest;


import com.oliverB.quickTutorial.dto.BlogPostDto;
import com.oliverB.quickTutorial.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class BlogController {

    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/blog")
    public String loadPage(Model model) {
        model.addAttribute("blogPostDto", new BlogPostDto());
        model.addAttribute("blogposts", blogService.getAllPosts());
        return "blog";
    }

    @PostMapping(value = "/blog/newblogpost")
    public String postNewBlogPost(Model model, @ModelAttribute BlogPostDto blogPostDto) {
        blogService.saveNewPost(blogPostDto);
        return "redirect:/blog";
    }



}
