package com.rouvsen.blogwebsitebackend.mapper;

import com.rouvsen.blogwebsitebackend.domain.Consultation;
import com.rouvsen.blogwebsitebackend.request.ConsultationRequest;
import com.rouvsen.blogwebsitebackend.response.ConsultationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ConsultationMapper {

    Consultation fromRequestToModel(ConsultationRequest consultationRequest);

    ConsultationResponse fromModelToResponse(Consultation consultation);

}
