/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.validation;

import com.exam.PR27.Dao.TestTypeDao;
import com.exam.PR27.dto.TestAddQuestionDto;
import com.exam.PR27.dto.TestDto;
import com.exam.PR27.entity.TestType;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author HoangMinh
 */
@Component
public class TestAddQuestionValidation implements Validator {
    @Autowired
    private TestTypeDao testTypeDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return TestAddQuestionDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TestAddQuestionDto testAddQuestionDto = (TestAddQuestionDto) o;
  

            if (testAddQuestionDto.getListQuestionId().size()==0) {
                 errors.rejectValue("listQuestionId","Số câu hỏi phải lớn hơn 1", "Số câu hỏi phải lớn hơn 1");
            }


    }

}
