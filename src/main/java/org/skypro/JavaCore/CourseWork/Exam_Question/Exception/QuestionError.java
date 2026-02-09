package org.skypro.JavaCore.CourseWork.Exam_Question.Exception;

public class QuestionError {
    private final String code;
    private final String message;

    public QuestionError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}