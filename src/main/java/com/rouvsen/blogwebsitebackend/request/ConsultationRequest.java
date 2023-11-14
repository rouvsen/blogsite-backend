package com.rouvsen.blogwebsitebackend.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ConsultationRequest {

    private String fullName;
    private String email;
    private String subject;
    private String phone;
    private String message;
    private LocalDate date;
    private LocalTime time;

}
