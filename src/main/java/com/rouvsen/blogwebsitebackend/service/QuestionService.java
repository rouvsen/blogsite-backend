package com.rouvsen.blogwebsitebackend.service;

import com.rouvsen.blogwebsitebackend.domain.Question;
import com.rouvsen.blogwebsitebackend.email.service.EmailService;
import com.rouvsen.blogwebsitebackend.repository.QuestionRepository;
import com.rouvsen.blogwebsitebackend.response.QuestionResponseList;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository repository;
    private final EmailService emailService;

    public QuestionService(QuestionRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }


    public Question addQuestionData(Question request) {
        Question saved = repository.save(request);
        System.out.println(saved);
        emailService.sendMailForQuestion(saved);
        return request;
//        {
//            "fullName": "Example",
//                "email": "example@.com",
//                "subject": "I have a question",
//                "phone": "1234567890",
//                "message": "hi, can you help me?",
//                "date": "2023-11-14",
//                "time": "02:32:26"
//        }
    }

    public QuestionResponseList getAllQuestions() {
        List<Question> all = repository.findAll();
        QuestionResponseList questionResponseList = new QuestionResponseList();
        List<Question> list = new ArrayList<>();
        if(!all.isEmpty()) {
            list.addAll(all);
        }
        questionResponseList.setQuestionResponse(list);
        return questionResponseList;
    }

}
