/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.validation;

import com.exam.PR27.entity.Question;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author HoangMinh
 */
@Component
public class QuestionValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Question.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Question question = (Question) o;
        if (question.getAnswer1() != null && question.getAnswer2() != null && question.getAnswer3() != null && question.getContent() != null && question.getContent() != null && question.getCorrectAnswer() != null) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer1", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer2", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "answer3", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "NotEmpty", "NotEmpty");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "correctAnswer", "NotEmpty", "NotEmpty");

        } else {
            errors.rejectValue("answer1", "Null","Null");
        }

    }

}
