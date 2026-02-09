package org.skypro.JavaCore.CourseWork.Exam_Question.controller;

import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionService;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.MathQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class MathQuestionController {

    private final QuestionService mathQuestionService;

    public MathQuestionController(@Qualifier("Math") QuestionService mathQuestionService) {
        this.mathQuestionService = mathQuestionService;
    }

    @PostMapping("/math/add")
    public ResponseEntity<?> addQuestion(@RequestBody MathQuestion question) {
        mathQuestionService.addQuestion(question);
        return new ResponseEntity<>("Ваш вопрос добавлен", HttpStatus.OK);
    }

    @GetMapping("/math/add")
    public ResponseEntity<?> addQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        mathQuestionService.addQuestion(questionText, answerText);
        return new ResponseEntity<>("Ваш вопрос добавлен", HttpStatus.OK);
    }

    @GetMapping("/math")
    public Collection<Question> getAll() {
        return mathQuestionService.getAll();
    }

    @GetMapping("/math/remove")
    public ResponseEntity<?> removeQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        mathQuestionService.removeQuestion(questionText, answerText);
        return new ResponseEntity<>("Ваш вопрос удален", HttpStatus.OK);
    }

    @DeleteMapping("/math/remove")
    public ResponseEntity<?> removeQuestion(@RequestBody MathQuestion question) {
        mathQuestionService.removeQuestion(question);
        return new ResponseEntity<>("Ваш вопрос удален", HttpStatus.OK);
    }
}