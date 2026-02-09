package org.skypro.JavaCore.CourseWork.Exam_Question.repository;

/*
Сервис для хранения вопросами по Math
*/

import org.skypro.JavaCore.CourseWork.Exam_Question.interfaces.QuestionRepository;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.MathQuestion;
import org.skypro.JavaCore.CourseWork.Exam_Question.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
@Qualifier("Math")
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
        fillQuestionList();
    }

    private void fillQuestionList() {
        addQuestion("В лестнице 11 ступеней. Став на какую из них, вы окажетесь посередине лестницы?", "На 6");
        addQuestion("В одном стакане 7 карандашей, во втором – на 5 больше, а в третьем – на 2 меньше, чем во втором. Сколько карандашей в трех стаканах?", "29");
        addQuestion("Маше 24 года, ее маме в 2 раза больше. Сколько лет Машиной сестре, если она младше мамы на 21 год?", "27");
        addQuestion("Если 10 сантиметров равны 1 дециметру, то сколько дециметров в 78 сантиметрах?", "7,8 дм");
        addQuestion("Один грузовик вмещает 3 тонны песка, а второй в 6 раз больше. Сколько килограммов песка поместится во второй грузовик?", "18000 кг");
        addQuestion("Рабочий день Кати длится 5 часов, а рабочий день ее подруги – 8 часов. Сколько минут в день обе девушки вместе тратят на работу?", "780");
        addQuestion("Юле и двум ее братьям подарили 36 подарков. Каждый гость подарил по 3 подарка каждому ребенку. Сколько было гостей?", "4");
        addQuestion("Дима пробежал марафон, дистанция которого равна 9 километрам. Сколько дециметров пробежал Дима?", "90 000");
        addQuestion("Белая свеча горит 7 часов, а синяя – 480 минут. Сколько часов горят обе свечи вместе?", "15");
        addQuestion("Одна книга стоит 2,86 руб. Сколько стоят 6 книг?", "17,16 руб");
    }

    private void addQuestion(String questionText, String answerText) {
        questions.add(new MathQuestion(questionText, answerText));
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