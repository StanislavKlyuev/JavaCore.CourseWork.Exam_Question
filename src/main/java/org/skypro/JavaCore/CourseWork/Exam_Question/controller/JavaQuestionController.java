package org.skypro.JavaCore.CourseWork.Exam_Question.controller;

import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionService;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.JavaQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {

    private final QuestionService javaQuestionService;

    public JavaQuestionController(@Qualifier("Java") QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @PostMapping("/java/add")
    public ResponseEntity<?> addQuestion(@RequestBody JavaQuestion question) {
        javaQuestionService.addQuestion(question);
        return new ResponseEntity<>("Ваш вопрос добавлен", HttpStatus.OK);
    }

    @GetMapping("/java/add")
    public ResponseEntity<?> addQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        javaQuestionService.addQuestion(questionText, answerText);
        return new ResponseEntity<>("Ваш вопрос добавлен", HttpStatus.OK);
    }

    @GetMapping("/java")
    public Collection<Question> getAll() {
        return javaQuestionService.getAll();
    }

    @GetMapping("/java/remove")
    public ResponseEntity<?> removeQuestion(@RequestParam("question") String questionText, @RequestParam("answer") String answerText) {
        javaQuestionService.removeQuestion(questionText, answerText);
        return new ResponseEntity<>("Ваш вопрос удален", HttpStatus.OK);
    }

    @DeleteMapping("/java/remove")
    public ResponseEntity<?> removeQuestion(@RequestBody JavaQuestion question) {
        javaQuestionService.removeQuestion(question);
        return new ResponseEntity<>("Ваш вопрос удален", HttpStatus.OK);
    }
}