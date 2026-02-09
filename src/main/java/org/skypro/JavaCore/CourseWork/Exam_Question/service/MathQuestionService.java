package org.skypro.JavaCore.CourseWork.Exam_Question.service;

/*
Сервис для управления вопросами по Math
*/

import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.ListOfQuestionIsEmptyException;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.QuestionIsPresentException;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.QuestionIsAbsentException;
import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionRepository;
import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionService;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.MathQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Qualifier("Math")
public class MathQuestionService implements QuestionService {

    private final QuestionRepository mathQuestionsRep;

    public MathQuestionService(@Qualifier("Math") QuestionRepository questionRep) {
        this.mathQuestionsRep = questionRep;
    }

    @Override
    public void addQuestion(String questionText, String answerText) {
        Collection<Question> questionSet = mathQuestionsRep.getAll();
        Question quest = new MathQuestion(questionText, answerText);
        if (questionSet.contains(quest)) {
            throw new QuestionIsPresentException();
        }
        mathQuestionsRep.addQuestion(quest);
    }

    @Override
    public void addQuestion(Question quest) {
        Collection<Question> questionSet = mathQuestionsRep.getAll();
        if (questionSet.contains(quest)) {
            throw new QuestionIsPresentException();
        }
        mathQuestionsRep.addQuestion(quest);
    }

    public Collection<Question> getAll() {
        Collection<Question> questionSet = mathQuestionsRep.getAll();
        if (questionSet.isEmpty()) {
            throw new ListOfQuestionIsEmptyException();
        }
        return questionSet;
    }

    public Question getRandomQuestion() {
        Collection<Question> questionSet = mathQuestionsRep.getAll();
        if (questionSet.isEmpty()) {
            throw new ListOfQuestionIsEmptyException();
        }
        Random random = new Random();
        return questionSet.stream()
                .skip(random.nextInt(questionSet.size()))
                .findFirst().orElse(null);
    }

    @Override
    public void removeQuestion(String questionText, String answerText) {
        Question quest = new MathQuestion(questionText, answerText);
        Collection<Question> questionSet = mathQuestionsRep.getAll();
        if (questionSet.isEmpty()) {
            throw new ListOfQuestionIsEmptyException();
        } else if (!questionSet.contains(quest)) {
            throw new QuestionIsAbsentException();
        }
        mathQuestionsRep.removeQuestion(quest);
    }

    @Override
    public void removeQuestion(Question quest) {
        Collection<Question> questionSet = mathQuestionsRep.getAll();
        if (questionSet.isEmpty()) {
            throw new ListOfQuestionIsEmptyException();
        } else if (!questionSet.contains(quest)) {
            throw new QuestionIsAbsentException();
        }
        mathQuestionsRep.removeQuestion(quest);
    }
}