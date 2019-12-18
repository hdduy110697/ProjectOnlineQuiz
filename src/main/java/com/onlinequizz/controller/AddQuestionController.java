package com.onlinequizz.controller;

import com.onlinequizz.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddQuestionController {
    @Autowired
    IQuestionService iQuestionService;
    @RequestMapping("/create-question")
    public String createQuestion(ModelMap model) {
        return "createquestion";
    }
    @GetMapping(value = "/add")
    public String createQuestionSubmit(ModelMap model,@RequestParam String answer1,@RequestParam String answer2
    ,@RequestParam String answer3,@RequestParam String answerCorrect,@RequestParam String context)
    {
        iQuestionService.SaveQuestion ( answer1,answer2,answer3,context,answerCorrect );
        return "createquestion";
    }
}
