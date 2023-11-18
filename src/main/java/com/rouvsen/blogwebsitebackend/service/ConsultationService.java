package com.rouvsen.blogwebsitebackend.service;

import com.rouvsen.blogwebsitebackend.domain.Consultation;
import com.rouvsen.blogwebsitebackend.email.service.EmailService;
import com.rouvsen.blogwebsitebackend.mapper.ConsultationMapper;
import com.rouvsen.blogwebsitebackend.repository.ConsultationRepository;
import com.rouvsen.blogwebsitebackend.response.ConsultationResponse;
import com.rouvsen.blogwebsitebackend.response.ConsultationResponseList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {

    private final ConsultationMapper mapper;
    private final ConsultationRepository repository;
    private final EmailService emailService;

    public ConsultationService(ConsultationMapper mapper, ConsultationRepository repository, EmailService emailService) {
        this.mapper = mapper;
        this.repository = repository;
        this.emailService = emailService;
    }

    public Consultation addConsultationData(Consultation request) {
        Consultation saved = repository.save(request);
        emailService.sendMailForConsultation(saved);
        return saved;
//        {
//            "fullName": "Example",
//                "email": "example@.com",
//                "subject": "I have a question",
//                "phone": "1234567890",
//                "message": "hi, can you help me?",
//                "date": "2023-11-14",
//                "time": "02:32:26"
//        }
    }

    public ConsultationResponseList getAllConsultations() {
        List<Consultation> all = repository.findAll();
        ConsultationResponseList consultationResponseList = new ConsultationResponseList();
        if(!all.isEmpty()) {
            consultationResponseList.setConsultationResponse(all);
        } else {
            consultationResponseList.setConsultationResponse(new ArrayList<>());
        }
        return consultationResponseList;
    }

}
