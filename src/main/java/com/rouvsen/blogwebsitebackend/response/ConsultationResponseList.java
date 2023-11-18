package com.rouvsen.blogwebsitebackend.response;

import com.rouvsen.blogwebsitebackend.domain.Consultation;
import lombok.Data;

import java.util.List;

@Data
public class ConsultationResponseList {

    private List<Consultation> consultationResponse;

}
