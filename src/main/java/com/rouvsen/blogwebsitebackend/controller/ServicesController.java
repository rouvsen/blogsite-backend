package com.rouvsen.blogwebsitebackend.controller;

import com.rouvsen.blogwebsitebackend.domain.Services;
import com.rouvsen.blogwebsitebackend.response.ServicesResponseList;
import com.rouvsen.blogwebsitebackend.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/services")
public class ServicesController {

    private final ServicesService servicesService;

    @PostMapping
    public ResponseEntity<Services> addServices(
            @RequestBody Services service) {
        return ResponseEntity.ok(servicesService.createServices(service));
    }

    @GetMapping
    public ResponseEntity<ServicesResponseList> getServiceList() {
        return ResponseEntity.ok(servicesService.getAllServices());
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<Services> getBlogById(@PathVariable Integer serviceId) {
        try {
            return ResponseEntity.ok(servicesService.getServices(serviceId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
