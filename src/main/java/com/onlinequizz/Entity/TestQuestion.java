package com.onlinequizz.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Test_Question")
public class TestQuestion {
    @EmbeddedId
    TestQuestionId testQuestionId;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public TestQuestionId getTestQuestionId() {
        return testQuestionId;
    }

    public void setTestQuestionId(TestQuestionId testQuestionId) {
        this.testQuestionId = testQuestionId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
