package org.skypro.JavaCore.CourseWork.Exam_Question.Exception;

public class MoreThenQuestionException extends RuntimeException {
    public MoreThenQuestionException() {
        super("Ваш запрос превышает количество доступных вопросов!");
    }
}