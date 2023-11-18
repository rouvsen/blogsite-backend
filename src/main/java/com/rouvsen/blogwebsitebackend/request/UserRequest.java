package com.rouvsen.blogwebsitebackend.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequest {

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String role;

}
