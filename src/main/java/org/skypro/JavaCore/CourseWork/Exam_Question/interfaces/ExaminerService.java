package org.skypro.JavaCore.CourseWork.Exam_Question.interfaces;

import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

    Question getRandomQuestion();
}