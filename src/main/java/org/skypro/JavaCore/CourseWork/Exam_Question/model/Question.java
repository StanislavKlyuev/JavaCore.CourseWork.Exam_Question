package org.skypro.JavaCore.CourseWork.Exam_Question.model;

import java.util.Objects;

public abstract class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (this == object) return true;
        Question quest = (Question) object;
        return Objects.equals(question, quest.question) && Objects.equals(answer, quest.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }
}