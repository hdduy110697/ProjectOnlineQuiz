package com.onlinequizz.Service.ImplService;

import com.onlinequizz.Entity.Question;
import com.onlinequizz.Responsitory.IQuestion;
import com.onlinequizz.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    IQuestion iQuestion;

    @Override
    public void SaveQuestion(String answer1, String answer2, String answer3, String context, String correctAnswer) {
        Question question=new Question ();
        question.setAnswer_1 ( answer1 );
        question.setAnswer_2 ( answer2 );
        question.setAnswer_3 ( answer3 );
        question.setContent ( context );
        question.setCorrectAnswer ( correctAnswer );
        iQuestion.save ( question );
    }
}
