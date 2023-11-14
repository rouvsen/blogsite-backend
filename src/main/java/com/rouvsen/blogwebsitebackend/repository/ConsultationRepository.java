package com.rouvsen.blogwebsitebackend.repository;

import com.rouvsen.blogwebsitebackend.domain.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository
    extends JpaRepository<Consultation, Integer> {
}
