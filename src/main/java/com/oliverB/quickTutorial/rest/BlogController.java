package com.oliverB.quickTutorial.controllers;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    @GetMapping("/blog")
    public String loadPage(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping("/newblogpost")
    public String postNewBlogPost(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        context.getBean("")
        model.addAttribute("name", name);
        return "greeting";
    }



}
