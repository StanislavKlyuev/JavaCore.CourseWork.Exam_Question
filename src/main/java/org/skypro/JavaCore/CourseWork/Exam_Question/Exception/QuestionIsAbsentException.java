package org.skypro.JavaCore.CourseWork.Exam_Question.Exception;

public class QuestionIsAbsentException extends RuntimeException {
    public QuestionIsAbsentException() {
        super("Такого вопроса нет!");
    }
}