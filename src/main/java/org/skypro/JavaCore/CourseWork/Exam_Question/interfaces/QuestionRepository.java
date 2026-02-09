package org.skypro.JavaCore.CourseWork.Exam_Question.interfaces;

import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    void addQuestion(Question question);

    Collection<Question> getAll();

    void removeQuestion(Question quest);
}