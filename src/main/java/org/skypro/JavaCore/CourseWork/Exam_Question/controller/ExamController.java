package org.skypro.JavaCore.CourseWork.Exam_Question.controller;

import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.ExaminerService;
import org.skypro.JavaCore.CourseWork.Exam_Question.service.ExaminerServiceImpl;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;


    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/random")
    public Question getRandomQuestion() {
        return examinerService.getRandomQuestion();
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getAmountQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}