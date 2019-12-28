package com.onlinequizz.Service.ImplService;

import com.onlinequizz.Entity.Question;
import com.onlinequizz.Responsitory.IQuestion;
import com.onlinequizz.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    IQuestion iQuestion;

    @Override
    public Question setQuestion(String answer1, String answer2, String answer3, String context, String correctAnswer) {
        Question question=new Question ();
        question.setAnswer_1 ( answer1 );
        question.setAnswer_2 ( answer2 );
        question.setAnswer_3 ( answer3 );
        question.setContent ( context );
        question.setCorrectAnswer ( correctAnswer );
        return question;
    }

    @Override
    @Transactional
    public void saveQuestion(String answer1, String answer2, String answer3, String context, String correctAnswer) {
        Question question=new Question ();
        question.setAnswer_1 ( answer1 );
        question.setAnswer_2 ( answer2 );
        question.setAnswer_3 ( answer3 );
        question.setContent ( context );
        question.setCorrectAnswer ( correctAnswer );
        iQuestion.save ( question );
    }

    @Override
    public Set<Question> findByListId(List<Integer> ids) {
        Set<Question> questions=new HashSet<Question> ();
        for (Integer id : ids) {
            questions.add ( iQuestion.findById ( id ).get () );
        }
        return questions;
    }

    @Override
    public List<Question> findAllQuestion() {
        return  iQuestion.findAll();
    }

    @Override
    public Integer getNumQuestion() {
        return iQuestion.findNumTest ();
    }

    @Override
    public List<Question> findAllPaging(int page, int record_page) {
        Page<Question> tests= iQuestion.findAll ( PageRequest.of(page-1, record_page, Sort.by("questionId").descending()) );
        List<Question> pageList = tests.getContent();
        return pageList;
    }
}
