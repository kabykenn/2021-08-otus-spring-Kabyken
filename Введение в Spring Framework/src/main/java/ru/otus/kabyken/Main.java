package ru.otus.kabyken;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.kabyken.domain.Question;
import ru.otus.kabyken.domain.Quiz;
import ru.otus.kabyken.service.QuizService;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizService service = context.getBean(QuizService.class);

        Quiz quiz = service.getByResource();
        List<Question> questionList = quiz.getQuestionList();


        for (Question q: questionList
             ) {
           System.out.println(q.getName());
        }

        // Данная операция, в принципе не нужна.
        // Мы не работаем пока что с БД, а Spring Boot сделает закрытие за нас
        // Подробности - через пару занятий
        context.close();
    }
}
