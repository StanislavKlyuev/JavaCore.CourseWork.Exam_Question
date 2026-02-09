package org.skypro.JavaCore.CourseWork.Exam_Question.Exception;

public class AmountWillBePositiveException extends RuntimeException {
    public AmountWillBePositiveException() {
        super("Количество запрошенных вопросов должно быть больше 0");
    }
}