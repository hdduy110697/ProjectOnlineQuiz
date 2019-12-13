package com.onlinequizz.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Test")
public class Test {
    @Id
    @Column(name = "test_id")
    private String testId;
    @Column(name = "active")
    private int description;
    @Column(name = "passWord")
    private String passWord;
    @Column(name = "question_number")
    private int questionNumber;
    @Column(name = "test_name")
    private String testName;
    @Column(name = "test_time")
    private  int testTime;
    @Column(name = "test_type_id")
    private  String testTypeId;
/*
    @ManyToOne
    @JoinColumn(name = "test_type_id")
    private TestType testType;
*/

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "test_question",joinColumns = {@JoinColumn(name = "test_id",referencedColumnName = "test_id")},
            inverseJoinColumns = {@JoinColumn(name = "question_id",referencedColumnName = "question_id")})
    private Set<Question> questions;

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public String getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(String testTypeId) {
        this.testTypeId = testTypeId;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestTime() {
        return testTime;
    }

    public void setTestTime(int testTime) {
        this.testTime = testTime;
    }
/*
    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }*/
}
