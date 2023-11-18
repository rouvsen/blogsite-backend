package com.rouvsen.blogwebsitebackend.response;

import com.rouvsen.blogwebsitebackend.domain.Blog;
import lombok.Data;

import java.util.List;

@Data
public class BlogResponseList {

    private List<Blog> blogs;
}
