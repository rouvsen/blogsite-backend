package com.rouvsen.blogwebsitebackend.response;

import com.rouvsen.blogwebsitebackend.domain.Services;
import lombok.Data;

import java.util.List;

@Data
public class ServicesResponseList {

    private List<Services> servicesList;
}
