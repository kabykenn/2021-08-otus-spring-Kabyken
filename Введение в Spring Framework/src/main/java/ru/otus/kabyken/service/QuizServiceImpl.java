package ru.otus.kabyken.service;

import ru.otus.kabyken.dao.QuizDao;
import ru.otus.kabyken.domain.Quiz;

public class QuizServiceImpl implements QuizService{
    private final QuizDao quizDao;

    QuizServiceImpl (QuizDao quizDao)
    {
        this.quizDao = quizDao;
    }
    @Override
    public Quiz getByResource() {
        return quizDao.findByResource();
    }
}
