package com.rouvsen.blogwebsitebackend.response;

import com.rouvsen.blogwebsitebackend.domain.Question;
import lombok.Data;

import java.util.List;

@Data
public class QuestionResponseList {

    private List<Question> questionResponse;

}
