package com.oliverB.quickTutorial.dao;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogPostDao {

    private String content;
    private String author;

    public BlogPostDao(String content, String author) {
        this.content = content;
        this.author = author;
    }


}
