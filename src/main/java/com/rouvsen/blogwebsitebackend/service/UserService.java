package com.rouvsen.blogwebsitebackend.service;

import com.rouvsen.blogwebsitebackend.domain.Role;
import com.rouvsen.blogwebsitebackend.domain.User;
import com.rouvsen.blogwebsitebackend.mapper.UserMapper;
import com.rouvsen.blogwebsitebackend.repository.UserRepository;
import com.rouvsen.blogwebsitebackend.request.UserRequest;
import com.rouvsen.blogwebsitebackend.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        if(Objects.nonNull(request)) {
            User user = mapper.fromRequestToModel(request);
            if (Objects.nonNull(repository.findByEmail(user.getEmail()).orElseGet(() -> null))) {
                return ResponseEntity.of(
                        ProblemDetail.forStatusAndDetail(
                                HttpStatus.CONFLICT,
                                "This email already exists..")
                        )
                        .build();
            }
            user.setRole(Role.ADMIN);
            User saved = repository.save(user);
            return
                    ResponseEntity.ok(
                            UserResponse.builder()
                                    .id(saved.getId())
                                    .email(saved.getEmail())
                                    .username(saved.getUsername())
                                    .role(String.valueOf(saved.getRole()))
                                    .fullName(saved.getFullName())
                                    .password(saved.getPassword())
                                    .message("User created successfully.")
                                    .build()
                    );
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<UserResponse> getUserById(Integer userId) {
        User user = repository.findById(userId).orElseGet(() -> null);
        if(Objects.nonNull(user)) {
            UserResponse userResponse = mapper.ModelToResponse(user);
            return ResponseEntity.ok(userResponse);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<UserResponse> getUserByEmail(String email) {
        User user = repository.findByEmail(email).orElseGet(() -> null);
        if(Objects.nonNull(user)) {
            UserResponse userResponse = mapper.ModelToResponse(user);
            return ResponseEntity.ok(userResponse);
        }
        return ResponseEntity.notFound().build();
    }


}
