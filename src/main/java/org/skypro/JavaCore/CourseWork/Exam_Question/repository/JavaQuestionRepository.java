package org.skypro.JavaCore.CourseWork.Exam_Question.repository;

/*
Сервис для хранения вопросами по Java
*/

import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionRepository;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.JavaQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
@Qualifier("Java")
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
        fillQuestionList();
    }

    private void fillQuestionList() {

        addQuestion("Что такое ООП?", "Объектно-ориентированное программирование — методология программирования, основанная на представлении программы в виде совокупности объектов, каждый из которых является экземпляром определенного класса, а классы образуют иерархию наследования.");
        addQuestion("Что такое класс в Java?", "Базовый элемент объектно-ориентированного программирования в языке Java.");
        addQuestion("Как объявить класс в коде?", "class MyClass {}");
        addQuestion("Для чего используется оператор NEW?", "Для создания экземпляра класса.");
        addQuestion("Что означает ключевое слово extends?", "Что данный класс наследуется от другого.");
        addQuestion("Что означает перегрузка метода в Java (overload).", "Несколько методов с одинаковым названием, но разным набором параметров.");
        addQuestion("Что означает переопределение метода в Java (override).", "Изменение поведения метода класса относительно родительского.");
        addQuestion("Чем отличаются static-метод класса от обычного метода класса.", "Обычный метод класса работает от объекта класса, а static-метод от всего класса.");
        addQuestion("Можно ли вызвать static-метод внутри обычного?", "Можно, ничего дополнительно делать не надо.");
        addQuestion("Как вызвать обычный метод класса внутри static-метода?", "Никак, static-метод не работает с объектом класса.");
        addQuestion("Для чего необходимо ключевое слово this", "Это указатель на текущий объект класса внутри самого класса. Его можно опускать при вызове метода класса, но лучше этого не делать.");
        addQuestion("Что вернет метод, объявленный следующим образом: public static int getAmount()", "Вернет целочисленное значение.");
        addQuestion("В переменных типа int в языке Java можно хранить", "Целые числа");
        addQuestion("Максимальное значение, которое можно хранить в переменной типа int в языке Java", "2 147 483 647");
        addQuestion("Переменная типа byte занимает в памяти N байт", "1");
        addQuestion("В языке Java преобразовать строку (содержащую цифры) в число можно командой:", "Integer.parsInt(\"123\")");
        addQuestion("В языке Java получить длину строки \"hello\" можно командой:", "hello.length()");
        addQuestion("В Java для чтения данных с консоли (с клавиатуры) используется стандартный класс", "Scanner");
        addQuestion("Специальный метод класса, который вызывается при создании объекта", "Конструктор");
        addQuestion("Если в программе (в блоке catch) перехвачено исключение, как вывести стек вызовов методов в консоль?", "e.printStackTrace()");
    }

    private void addQuestion(String questionText, String answerText) {
        questions.add(new JavaQuestion(questionText, answerText));
    }

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }
}