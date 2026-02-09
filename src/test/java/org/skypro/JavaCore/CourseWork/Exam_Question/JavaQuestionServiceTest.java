package org.skypro.JavaCore.CourseWork.Exam_Question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.ListOfQuestionIsEmptyException;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.QuestionIsAbsentException;
import org.skypro.JavaCore.CourseWork.Exam_Question.Exception.QuestionIsPresentException;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.JavaQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.skypro.JavaCore.CourseWork.Exam_Question.repository.JavaQuestionRepository;
import org.skypro.JavaCore.CourseWork.Exam_Question.service.JavaQuestionService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {

    @Mock
    JavaQuestionRepository javaQuestionsRep;

    @InjectMocks
    JavaQuestionService javaQuestionService;

    @Test
    public void addQuestionByStringWhenQuestionIsPresent_ThenReturnQuestionIsPresentException() {                   //Добавление дубликата при @GetMapping
        Question questTest = new JavaQuestion("questionText", "answerText");
        when(javaQuestionsRep.getAll()).thenReturn(Collections.singletonList(questTest));
        assertThrows(QuestionIsPresentException.class, () -> javaQuestionService.addQuestion("questionText", "answerText"));
        verify(javaQuestionsRep, times(1)).getAll();
    }

    @Test
    public void addQuestionByQuestionWhenQuestionIsPresent_ThenReturnQuestionIsPresentException() {                   //Добавление дубликата при @PostMapping
        Question questTest = new JavaQuestion("questionText", "answerText");
        Question questTest2 = new JavaQuestion("questionText", "answerText");
        when(javaQuestionsRep.getAll()).thenReturn(Collections.singletonList(questTest));
        assertThrows(QuestionIsPresentException.class, () -> javaQuestionService.addQuestion(questTest2));
        verify(javaQuestionsRep, times(1)).getAll();
    }


    @Test
    public void getAllwhenQuestionSetIsEmpty_ThenReturnListOfQuestionIsEmptyException() {             //получение пуcтой коллекции
        when(javaQuestionsRep.getAll()).thenReturn(Collections.emptyList());
        assertThrows(ListOfQuestionIsEmptyException.class, () -> javaQuestionService.getAll());
        verify(javaQuestionsRep, times(1)).getAll();
    }

    @Test
    public void whenQuestionSetIsEmpty_ThenReturnListOfQuestionIsEmptyException() {             //Удаление вопроса при пустом репозитории
        when(javaQuestionsRep.getAll()).thenReturn(Collections.emptyList());
        assertThrows(ListOfQuestionIsEmptyException.class, () -> javaQuestionService.removeQuestion("questionText", "answerText"));
        verify(javaQuestionsRep, times(1)).getAll();
    }

    @Test
    public void removeQuestionByStringWhenQuestionIsAbsent_ThenReturnQuestionIsAbsentException() {             //Удаление вопроса, которого нет в репозитории при @GetMapping
        Collection<Question> questionsTest = new HashSet<>();
        questionsTest.add(new JavaQuestion("questionText", "answerText"));
        when(javaQuestionsRep.getAll()).thenReturn(questionsTest);
        assertThrows(QuestionIsAbsentException.class, () -> javaQuestionService.removeQuestion("questionText2", "answerText2"));
        verify(javaQuestionsRep, times(1)).getAll();
    }

    @Test
    public void removeQuestionByQuestionWhenQuestionIsAbsent_ThenReturnQuestionIsAbsentException() {             //Удаление вопроса, которого нет в репозитории при @PostMapping
        Question questTest = new JavaQuestion("questionText", "answerText");
        Question questTest2 = new JavaQuestion("questionText2", "answerText2");
        when(javaQuestionsRep.getAll()).thenReturn(Collections.singletonList(questTest));
        assertThrows(QuestionIsAbsentException.class, () -> javaQuestionService.removeQuestion(questTest2));
        verify(javaQuestionsRep, times(1)).getAll();
    }
}