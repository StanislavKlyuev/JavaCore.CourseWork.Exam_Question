package org.skypro.JavaCore.CourseWork.Exam_Question.Exception;

public class ListOfQuestionIsEmptyException extends RuntimeException {
    public ListOfQuestionIsEmptyException() {
        super("Перечень вопросов пустой. Для начала работы добавьте вопросы.");
    }
}