package com.rouvsen.blogwebsitebackend.service;

import com.rouvsen.blogwebsitebackend.domain.Services;
import com.rouvsen.blogwebsitebackend.exception.ServiceNotFoundException;
import com.rouvsen.blogwebsitebackend.repository.ServicesRepository;
import com.rouvsen.blogwebsitebackend.response.ServicesResponseList;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {

    private final ServicesRepository repository;

    public ServicesService(ServicesRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Services createServices(Services request) {
        return repository.save(request);
    }

    public ServicesResponseList getAllServices() {
        List<Services> all = repository.findAll();
        ServicesResponseList servicesResponseList = new ServicesResponseList();
        if (!all.isEmpty()) {
            servicesResponseList.setServicesList(all);
        } else {
            servicesResponseList.setServicesList(new ArrayList<>());
        }
        return servicesResponseList;
    }

    public Services getServices(Integer servicesId) {
        Optional<Services> byId = repository.findById(servicesId);
        if(byId.isEmpty()) {
            throw new ServiceNotFoundException("Service doesn't exist..");
        }
        return byId.get();
    }
}
