package com.oliverB.quickTutorial.service;

import com.oliverB.quickTutorial.dao.BlogPostDao;
import com.oliverB.quickTutorial.dataTypes.BlogPost;
import com.oliverB.quickTutorial.dto.BlogPostDto;
import com.oliverB.quickTutorial.repositories.BlogDataRetrivalInterface;
import com.oliverB.quickTutorial.repositories.BlogDataRetrivalService;
import com.oliverB.quickTutorial.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService  {

    @Autowired
    BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public List<BlogPostDao> getAllPosts() {
        List<BlogPostDao> returnList = new ArrayList<>();
        for (BlogPost blogPost : blogRepository.findAll()) {
            returnList.add(new BlogPostDao(blogPost.getContent(), blogPost.getAuthor()));
        }
        return returnList;
    }


    public void saveNewPost(BlogPostDto blogPostDto) {
        BlogPost newPost = new BlogPost();
        newPost.setAuthor(blogPostDto.getAuthor());
        newPost.setContent(blogPostDto.getContent());
        blogRepository.save(newPost);
    }
}
