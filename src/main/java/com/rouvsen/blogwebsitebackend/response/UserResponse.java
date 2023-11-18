package com.rouvsen.blogwebsitebackend.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private Integer id;

    private String username;

    private String password;

    private String fullName;

    private String email;

    private String role;

    private String message;

}
