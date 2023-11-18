package com.rouvsen.blogwebsitebackend.controller;

import com.rouvsen.blogwebsitebackend.request.UserRequest;
import com.rouvsen.blogwebsitebackend.response.UserResponse;
import com.rouvsen.blogwebsitebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest request) {
            return service.createUser(request);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Integer userId) {
        return service.getUserById(userId);
    }

    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable("email") String email) {
        return service.getUserByEmail(email);
    }
}
