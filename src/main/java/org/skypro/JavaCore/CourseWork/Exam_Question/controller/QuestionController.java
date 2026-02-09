package org.skypro.JavaCore.CourseWork.Exam_Question.controller;

import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionService;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.HashSet;

@RestController
@RequestMapping("/exam")
public class QuestionController {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public QuestionController(@Qualifier("Java") QuestionService javaQuestionService, @Qualifier("Math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @GetMapping("/getall")
    public Collection<Question> getAll() {
        Collection<Question> questions = new HashSet<>();
        questions.addAll(javaQuestionService.getAll());
        questions.addAll(mathQuestionService.getAll());
        return questions;
    }
}