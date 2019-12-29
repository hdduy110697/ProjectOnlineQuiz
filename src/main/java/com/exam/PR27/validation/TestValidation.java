/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.validation;

import com.exam.PR27.Dao.TestTypeDao;
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
public class TestValidation implements Validator {
    @Autowired
    private TestTypeDao testTypeDao;

    @Override
    public boolean supports(Class<?> aClass) {
        return TestDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TestDto testDto = (TestDto) o;
        if (testDto.getDescription() != null && testDto.getPassword() != null && testDto.getTestName() != null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "testName", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty", "NotEmpty");
            if (testDto.getTestTime()==0) {
                 errors.rejectValue("testTime", "Phải khác 0","Phải khác 0");
            }
            if (testDto.getQuestionNumber()==0) {
                 errors.rejectValue("questionNumber","Phải khác 0", "Phải khác 0");
            }

        } else {
            errors.rejectValue("answer1", "Null","Null");
        }

    }

}
