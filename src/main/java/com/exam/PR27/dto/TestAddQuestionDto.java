/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.dto;

import java.util.List;

/**
 *
 * @author HoangMinh
 */
public class TestAddQuestionDto {
    private int testId;
    private List<Integer> listQuestionId;

    public TestAddQuestionDto() {
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public List<Integer> getListQuestionId() {
        return listQuestionId;
    }

    public void setListQuestionId(List<Integer> listQuestionId) {
        this.listQuestionId = listQuestionId;
    }
    
}
