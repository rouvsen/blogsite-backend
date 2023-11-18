package com.rouvsen.blogwebsitebackend.repository;

import com.rouvsen.blogwebsitebackend.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository
    extends JpaRepository<Blog, Integer> {
}
