package com.rouvsen.blogwebsitebackend.email.consultation;

import com.rouvsen.blogwebsitebackend.domain.Consultation;
import com.rouvsen.blogwebsitebackend.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sendConsultationEmail")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendConsultationEmail(
            @RequestBody  Consultation consultation) {
        try {
            emailService.sendMail(consultation);
            return ResponseEntity.ok("Email send successfully");
        } catch (Exception e) {
            return ResponseEntity.of(
                    ProblemDetail.forStatusAndDetail(
                            HttpStatus.BAD_REQUEST,
                            "Failed to send email"
                    )
            ).build();
        }
    }

}
