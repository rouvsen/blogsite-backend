package com.rouvsen.blogwebsitebackend.repository;

import com.rouvsen.blogwebsitebackend.domain.Services;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository
        extends JpaRepository<Services, Integer> {
}
