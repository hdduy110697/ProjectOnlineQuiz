package com.onlinequizz.Service;

import com.onlinequizz.Entity.Question;

import java.util.List;

public interface IQuestionService {
    void saveQuestion(String answer1,String answer2,String answer3,String context,String correctAnswer);
    List<Question> findAllQuestion();
}
