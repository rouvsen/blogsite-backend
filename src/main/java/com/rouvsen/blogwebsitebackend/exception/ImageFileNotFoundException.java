package com.rouvsen.blogwebsitebackend.exception;

public class ImageFileNotFoundException extends RuntimeException{
    public ImageFileNotFoundException(String message) {
        super(message);
    }
}
