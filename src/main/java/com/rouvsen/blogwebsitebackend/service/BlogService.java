package com.rouvsen.blogwebsitebackend.service;

import com.rouvsen.blogwebsitebackend.domain.Blog;
import com.rouvsen.blogwebsitebackend.domain.Consultation;
import com.rouvsen.blogwebsitebackend.repository.BlogRepository;
import com.rouvsen.blogwebsitebackend.response.BlogResponseList;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository repository;

    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Blog createBlog(Blog request) {
        //TODO: Write ImageSaver and downloader service&Api
        return repository.save(request);
//         {
//            "blogImage": "vvct345345v34c34c",
//            "author": "Rovshan",
//            "content": "test content",
//            "date": "2023-05-20"
//          }
    }

    public BlogResponseList getAllBlogs() {
        List<Blog> all = repository.findAll();
        BlogResponseList blogResponseList = new BlogResponseList();
        if (!all.isEmpty()) {
            blogResponseList.setBlogs(all);
        } else {
            blogResponseList.setBlogs(new ArrayList<>());
        }
        return blogResponseList;
    }
}
