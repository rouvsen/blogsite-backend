package com.rouvsen.blogwebsitebackend.repository;

import com.rouvsen.blogwebsitebackend.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository
    extends JpaRepository<Question, Integer> {
}
