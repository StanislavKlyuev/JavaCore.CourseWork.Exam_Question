package org.skypro.JavaCore.CourseWork.Exam_Question.controller;

import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class QuestionControllerAdvice {
    @ExceptionHandler(MoreThenQuestionException.class)
    public ResponseEntity<QuestionError> moreThenQuestionExceptionHandler(MoreThenQuestionException e) {
        return ResponseEntity.badRequest().body(new QuestionError(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
    }

    @ExceptionHandler(QuestionIsPresentException.class)
    public ResponseEntity<QuestionError> QuestionIsPresentException(QuestionIsPresentException e) {
        return ResponseEntity.badRequest().body(new QuestionError(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
    }

    @ExceptionHandler(QuestionIsAbsentException.class)
    public ResponseEntity<QuestionError> QuestionIsAbsentException(QuestionIsAbsentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new QuestionError(HttpStatus.NOT_FOUND.toString(), e.getMessage()));
    }

    @ExceptionHandler(ListOfQuestionIsEmptyException.class)
    public ResponseEntity<QuestionError> ListOfQuestionIsEmptyException(ListOfQuestionIsEmptyException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new QuestionError(HttpStatus.NOT_FOUND.toString(), e.getMessage()));
    }

    @ExceptionHandler(AmountWillBePositiveException.class)
    public ResponseEntity<QuestionError> AmountWillBePositiveException(AmountWillBePositiveException e) {
        return ResponseEntity.badRequest().body(new QuestionError(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
    }
}