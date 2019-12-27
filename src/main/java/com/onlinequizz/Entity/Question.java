package com.onlinequizz.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    @Column(name = "question_id",length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    @Column(name = "answer_1",length = 100)
    private String answer_1;
    @Column(name = "answer_2",length = 100)
    private String answer_2;
    @Column(name = "answer_3",length = 100)
    private String answer_3;
    @Column(name = "content",length = 100)
    private String content;
    @Column(name = "correct_answer",length = 100)
    private String correctAnswer;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "test_question",joinColumns = {@JoinColumn(name = "question_id",referencedColumnName = "question_id")},
            inverseJoinColumns = {@JoinColumn(name = "test_id",referencedColumnName = "test_id")})
    private Set<Test> questions;
    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getAnswer_1() {
        return answer_1;
    }

    public void setAnswer_1(String answer_1) {
        this.answer_1 = answer_1;
    }

    public String getAnswer_2() {
        return answer_2;
    }

    public void setAnswer_2(String answer_2) {
        this.answer_2 = answer_2;
    }

    public String getAnswer_3() {
        return answer_3;
    }

    public void setAnswer_3(String answer_3) {
        this.answer_3 = answer_3;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
