package com.rouvsen.blogwebsitebackend.controller;

import com.rouvsen.blogwebsitebackend.domain.Consultation;
import com.rouvsen.blogwebsitebackend.request.ConsultationRequest;
import com.rouvsen.blogwebsitebackend.response.ConsultationResponse;
import com.rouvsen.blogwebsitebackend.response.ConsultationResponseList;
import com.rouvsen.blogwebsitebackend.service.ConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/consultations")
@CrossOrigin(origins = "*")
public class ConsultationController {

    private final ConsultationService service;

    public ConsultationController(ConsultationService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ConsultationResponseList> getAllConsultations() {
        return ResponseEntity.ok(service.getAllConsultations());
    }

    @PostMapping
    public ResponseEntity<Consultation> saveConsultation(
            @RequestBody Consultation request
            ) {
        return ResponseEntity.ok(service.addConsultationData(request));
    }

}
