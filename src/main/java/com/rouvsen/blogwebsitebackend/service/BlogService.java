package com.rouvsen.blogwebsitebackend.service;

import com.rouvsen.blogwebsitebackend.domain.Blog;
import com.rouvsen.blogwebsitebackend.exception.BlogNotFoundException;
import com.rouvsen.blogwebsitebackend.repository.BlogRepository;
import com.rouvsen.blogwebsitebackend.response.BlogResponseList;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private final BlogRepository repository;

    public BlogService(BlogRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Blog createBlog(Blog request) {
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

    public Blog getBlog(Integer blogId) {
        Optional<Blog> byId = repository.findById(blogId);
        if(byId.isEmpty()) {
            throw new BlogNotFoundException("Blog doesn't exist..");
        }
        return byId.get();
    }
}
