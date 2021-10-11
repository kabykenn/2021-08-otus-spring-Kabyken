package ru.otus.kabyken.domain;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questionList;
    private static final String[] HEADERS = {"id","name","answer"};

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestions(String path) throws IOException {
        List<Question> questions = new ArrayList<>();
        Reader in = new FileReader(path);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .withFirstRecordAsHeader()
                .withDelimiter(';')
                .withIgnoreEmptyLines()
                .withTrailingDelimiter()
                .parse(in);
        for (CSVRecord record : records) {
            String id = record.get("id");
            String name = record.get("name");
            String answer = record.get("answer");

            questions.add(new Question(Integer.parseInt(id),name,Integer.parseInt(answer)));
        }


        this.questionList = questions;
    }
}
