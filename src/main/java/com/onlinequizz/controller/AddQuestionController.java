package com.onlinequizz.controller;

import com.onlinequizz.Entity.Question;
import com.onlinequizz.Entity.Test;
import com.onlinequizz.Service.IQuestionService;
import com.onlinequizz.Service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddQuestionController {
    @Autowired
    IQuestionService iQuestionService;
    @Autowired
    ITestService iTestService;
    @RequestMapping("/create-question*")
    public String createQuestion(ModelMap model) {
        return "createquestion";
    }
    @RequestMapping("/question-manager")
    public String questionManager(ModelMap model) {
        Integer numAll=iQuestionService.getNumQuestion ();
        Integer numRecordPage=3;
        Integer numPage=0;
        if(numAll%numRecordPage==0)
            numPage=(numAll/numRecordPage);
        else
            numPage=(numAll/numRecordPage)+1;
        List<Question> pageList=iQuestionService.findAllPaging ( 1,numRecordPage );
        model.addAttribute ( "totalPage" ,numPage);
        model.addAttribute ( "currentPage",1 );
        model.addAttribute ( "questions",pageList );
        return "welcome";
    }
    @RequestMapping("/quest-manager/page")
    public String questionPage(@RequestParam Integer page, @RequestParam Integer limit,ModelMap model) {
        Integer numAll=iQuestionService.getNumQuestion ();
        Integer numRecordPage=3;
        Integer numPage=0;
        if(numAll%numRecordPage==0)
            numPage=(numAll/numRecordPage);
        else
            numPage=(numAll/numRecordPage)+1;
        List<Question>  pageList=iQuestionService.findAllPaging ( page,numRecordPage );
        model.addAttribute ( "totalPage" ,numPage);
        model.addAttribute ( "currentPage",page );
        model.addAttribute ( "questions",pageList );
        return "welcome";
    }

    @GetMapping(value = "/add")
    public String createQuestionSubmit(ModelMap model,@RequestParam String answer1,@RequestParam String answer2
    ,@RequestParam String answer3,@RequestParam String answerCorrect,@RequestParam String context)
    {
        iQuestionService.saveQuestion ( answer1,answer2,answer3,context,answerCorrect );
        return "redirect:/question-manager";
    }
}
