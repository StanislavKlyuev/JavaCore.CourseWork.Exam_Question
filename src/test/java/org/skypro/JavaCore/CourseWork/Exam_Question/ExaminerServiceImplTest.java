package org.skypro.JavaCore.CourseWork.Exam_Question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.*;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.JavaQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.skypro.JavaCore.CourseWork.Exam_Question.service.ExaminerServiceImpl;
import org.skypro.JavaCore.CourseWork.Exam_Question.service.JavaQuestionService;
import org.skypro.JavaCore.CourseWork.Exam_Question.service.MathQuestionService;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @Mock
    private MathQuestionService mathQuestionService;

    @InjectMocks
    ExaminerServiceImpl examinerServiceImpl;

    @Test
    public void whenAmountMoreThenQuestions_ThenReturnMoreThenQuestionException() {       //Запрос количества вопросов больше размера репозитория
        Question question = new JavaQuestion("questionTest", "answerTest");
        Question question2 = new JavaQuestion("questionTest2", "answerTest2");
        when(javaQuestionService.getAll()).thenReturn(Collections.singletonList(question));
        when(mathQuestionService.getAll()).thenReturn(Collections.singletonList(question2));
        assertThrows(MoreThenQuestionException.class, () -> examinerServiceImpl.getQuestions(3));
        verify(javaQuestionService, times(1)).getAll();
        verify(mathQuestionService, times(1)).getAll();
    }

    @Test
    public void whenAmountIsZero_ThenReturnAmountWillBePositiveException() {            //Запрос 0 вопросов
        int amount = 0;
        assertThrows(AmountWillBePositiveException.class, () -> examinerServiceImpl.getQuestions(amount));
    }

    @Test
    public void whenAmountIsNegative_ThenReturnAmountWillBePositiveException() {        //Запрос отрицательного количества
        int amount = -1;
        assertThrows(AmountWillBePositiveException.class, () -> examinerServiceImpl.getQuestions(amount));
    }

    @Test
    public void whenQuestionSetIsEmpty_ThenReturnListOfQuestionIsEmptyException() {             //Запрос при пустом java-репозитории
        int amount = 1;
        when(javaQuestionService.getAll()).thenThrow(new ListOfQuestionIsEmptyException());
        assertThrows(ListOfQuestionIsEmptyException.class, () -> examinerServiceImpl.getQuestions(amount));
        verify(javaQuestionService, times(1)).getAll();
    }

    @Test
    public void whenuestionSetIsEmpty_ThenReturnListOfQuestionIsEmptyException() {             //Запрос при пустом math-репозитории
        int amount = 1;
        when(mathQuestionService.getAll()).thenThrow(new ListOfQuestionIsEmptyException());
        assertThrows(ListOfQuestionIsEmptyException.class, () -> examinerServiceImpl.getQuestions(amount));
        verify(mathQuestionService, times(1)).getAll();
    }
}