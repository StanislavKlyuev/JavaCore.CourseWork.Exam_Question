package org.skypro.JavaCore.CourseWork.Exam_Question.Exception;

public class QuestionIsPresentException extends RuntimeException {
    public QuestionIsPresentException() {
        super("Такой вопрос уже имеется");
    }
}