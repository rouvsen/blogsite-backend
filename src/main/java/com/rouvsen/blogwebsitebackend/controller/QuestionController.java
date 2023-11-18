package com.rouvsen.blogwebsitebackend.controller;

import com.rouvsen.blogwebsitebackend.domain.Question;
import com.rouvsen.blogwebsitebackend.response.QuestionResponseList;
import com.rouvsen.blogwebsitebackend.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "*")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<QuestionResponseList> getAllQuestions() {
        return ResponseEntity.ok(service.getAllQuestions());
    }

    @PostMapping
    public ResponseEntity<Question> saveQuestion(
            @RequestBody Question request
    ) {
        return ResponseEntity.ok(service.addQuestionData(request));
    }

}

