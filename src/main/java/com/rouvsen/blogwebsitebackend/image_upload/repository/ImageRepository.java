package com.rouvsen.blogwebsitebackend.image_upload.repository;

import com.rouvsen.blogwebsitebackend.image_upload.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByName(String name);

}
