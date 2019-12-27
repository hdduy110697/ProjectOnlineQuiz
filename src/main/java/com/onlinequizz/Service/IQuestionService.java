package com.onlinequizz.Service;

import com.onlinequizz.Entity.Question;

import java.util.List;
import java.util.Set;

public interface IQuestionService {
    Question setQuestion(String answer1,String answer2,String answer3,String context,String correctAnswer);
    void saveQuestion(String answer1,String answer2,String answer3,String context,String correctAnswer);
    Set<Question> findByListId(List<Integer> ids);
    List<Question> findAllQuestion();
    Integer getNumQuestion();
    List<Question> findAllPaging(int page,int record_page);
}
