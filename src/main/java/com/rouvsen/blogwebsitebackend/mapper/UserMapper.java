package com.rouvsen.blogwebsitebackend.mapper;

import com.rouvsen.blogwebsitebackend.domain.User;
import com.rouvsen.blogwebsitebackend.request.UserRequest;
import com.rouvsen.blogwebsitebackend.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User fromRequestToModel(UserRequest request);

    UserResponse ModelToResponse(User user);
}
