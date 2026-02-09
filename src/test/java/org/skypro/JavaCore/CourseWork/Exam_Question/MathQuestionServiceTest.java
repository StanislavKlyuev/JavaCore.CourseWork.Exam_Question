package org.skypro.JavaCore.CourseWork.Exam_Question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.ListOfQuestionIsEmptyException;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.QuestionIsAbsentException;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.QuestionIsPresentException;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.MathQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.skypro.JavaCore.CourseWork.Exam_Question.repository.MathQuestionRepository;
import org.skypro.JavaCore.CourseWork.Exam_Question.service.MathQuestionService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {

    @Mock
    MathQuestionRepository mathQuestionsRep;

    @InjectMocks
    MathQuestionService mathQuestionService;

    @Test
    public void addQuestionByStringWhenQuestionIsPresent_ThenReturnQuestionIsPresentException() {                   //Добавление дубликата при @GetMapping
        Question questTest = new MathQuestion("questionText", "answerText");
        when(mathQuestionsRep.getAll()).thenReturn(Collections.singletonList(questTest));
        assertThrows(QuestionIsPresentException.class, () -> mathQuestionService.addQuestion("questionText", "answerText"));
        verify(mathQuestionsRep, times(1)).getAll();
    }

    @Test
    public void addQuestionByQuestionWhenQuestionIsPresent_ThenReturnQuestionIsPresentException() {                   //Добавление дубликата при @PostMapping
        Question questTest = new MathQuestion("questionText", "answerText");
        Question questTest2 = new MathQuestion("questionText", "answerText");
        when(mathQuestionsRep.getAll()).thenReturn(Collections.singletonList(questTest));
        assertThrows(QuestionIsPresentException.class, () -> mathQuestionService.addQuestion(questTest2));
        verify(mathQuestionsRep, times(1)).getAll();
    }

    @Test
    public void getAllwhenQuestionSetIsEmpty_ThenReturnListOfQuestionIsEmptyException() {             //получение пуcтой коллекции
        when(mathQuestionsRep.getAll()).thenReturn(Collections.emptyList());
        assertThrows(ListOfQuestionIsEmptyException.class, () -> mathQuestionService.getAll());
        verify(mathQuestionsRep, times(1)).getAll();
    }

    @Test
    public void whenQuestionSetIsEmpty_ThenReturnListOfQuestionIsEmptyException() {             //Удаление вопроса при пустом репозитории
        when(mathQuestionsRep.getAll()).thenReturn(Collections.emptyList());
        assertThrows(ListOfQuestionIsEmptyException.class, () -> mathQuestionService.removeQuestion("questionText", "answerText"));
        verify(mathQuestionsRep, times(1)).getAll();
    }

    @Test
    public void removeQuestionByStringWhenQuestionIsAbsent_ThenReturnQuestionIsAbsentException() {             //Удаление вопроса, которого нет в репозитории при @GetMapping
        Collection<Question> questionsTest = new HashSet<>();
        questionsTest.add(new MathQuestion("questionText", "answerText"));
        when(mathQuestionsRep.getAll()).thenReturn(questionsTest);
        assertThrows(QuestionIsAbsentException.class, () -> mathQuestionService.removeQuestion("questionText2", "answerText2"));
        verify(mathQuestionsRep, times(1)).getAll();
    }

    @Test
    public void removeQuestionByQuestionWhenQuestionIsAbsent_ThenReturnQuestionIsAbsentException() {             //Удаление вопроса, которого нет в репозитории при @PostMapping
        Question questTest = new MathQuestion("questionText", "answerText");
        Question questTest2 = new MathQuestion("questionText2", "answerText2");
        when(mathQuestionsRep.getAll()).thenReturn(Collections.singletonList(questTest));
        assertThrows(QuestionIsAbsentException.class, () -> mathQuestionService.removeQuestion(questTest2));
        verify(mathQuestionsRep, times(1)).getAll();
    }
}