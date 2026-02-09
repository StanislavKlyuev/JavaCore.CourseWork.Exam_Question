package org.skypro.JavaCore.CourseWork.Exam_Question.service;

/*
Сервис управления вопросами для экзамена
*/

import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.AmountWillBePositiveException;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.MoreThenQuestionException;
import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.ExaminerService;
import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionService;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("Java") QuestionService javaQuestionService, @Qualifier("Math") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0) {
            throw new AmountWillBePositiveException();
        }
        Random random = new Random();
        Collection<Question> questions = new HashSet<>();
        Collection<Question> temp = new HashSet<>();
        temp.addAll(javaQuestionService.getAll());
        temp.addAll(mathQuestionService.getAll());
        if (amount > temp.size()) {
            throw new MoreThenQuestionException();
        }
        while (questions.size() < amount) {
            questions.add(temp.stream()
                    .skip(random.nextInt(temp.size()))
                    .findFirst().orElse(null));
        }
        return questions;
    }

    public Question getRandomQuestion() {
        Collection<Question> questions = new HashSet<>();
        questions.addAll(javaQuestionService.getAll());
        questions.addAll(mathQuestionService.getAll());
        Random random = new Random();
        return questions.stream()
                .skip(random.nextInt(questions.size()))
                .findFirst().orElse(null);
    }
}