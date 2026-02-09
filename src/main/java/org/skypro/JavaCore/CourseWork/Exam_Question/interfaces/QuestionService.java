package org.skypro.JavaCore.CourseWork.Exam_Question.interfaces;

import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;

import java.util.Collection;

public interface QuestionService {

    void addQuestion(String questionText, String answerText);

    void addQuestion(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

    void removeQuestion(String questionText, String answerText);

    void removeQuestion(Question quest);
}
