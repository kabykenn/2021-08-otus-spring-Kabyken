package ru.otus.kabyken.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.otus.kabyken.domain.Quiz;

import java.io.IOException;

public class QuizDaoSimple implements QuizDao{
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Quiz findByResource() {
        Quiz quiz = new Quiz();
        Resource resource = new ClassPathResource(this.fileName);
        try{
            quiz.addQuestions(resource.getFile().toString());
        }
        catch (IOException i){
            i.printStackTrace();
        }

        return quiz;
    }
}
