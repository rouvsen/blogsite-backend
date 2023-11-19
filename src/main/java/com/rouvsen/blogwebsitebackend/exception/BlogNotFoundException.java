package com.rouvsen.blogwebsitebackend.exception;

public class BlogNotFoundException extends RuntimeException{
    public BlogNotFoundException(String message) {
        super(message);
    }
}
