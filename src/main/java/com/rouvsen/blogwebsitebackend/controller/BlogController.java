package com.rouvsen.blogwebsitebackend.controller;

import com.rouvsen.blogwebsitebackend.domain.Blog;
import com.rouvsen.blogwebsitebackend.response.BlogResponseList;
import com.rouvsen.blogwebsitebackend.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    private final BlogService service;

    public BlogController(BlogService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Blog> addBlog(
            @RequestBody Blog blog) {
        return ResponseEntity.ok(service.createBlog(blog));
    }

    @GetMapping
    public ResponseEntity<BlogResponseList> getBlogList() {
        return ResponseEntity.ok(service.getAllBlogs());
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer blogId) {
        try {
            return ResponseEntity.ok(service.getBlog(blogId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
