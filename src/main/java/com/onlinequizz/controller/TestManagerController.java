package com.onlinequizz.controller;

import com.onlinequizz.Entity.Question;
import com.onlinequizz.Entity.Test;
import com.onlinequizz.Responsitory.IQuestion;
import com.onlinequizz.Service.IQuestionService;
import com.onlinequizz.Service.ITestService;
import com.onlinequizz.Service.ITestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

@Controller
public class TestManagerController {
    @Autowired
    ITestService iTestService;
    @Autowired
    ITestTypeService iTestTypeService;
    @Autowired
    IQuestionService iQuestionService;
    @RequestMapping("/test-manager")
    public String testManager(ModelMap model) {
        Integer numAll=iTestService.getNumTest ();
        Integer numRecordPage=3;
        Integer numPage=0;
        if(numAll%numRecordPage==0)
            numPage=(numAll/numRecordPage);
        else
            numPage=(numAll/numRecordPage)+1;
        List<Test> pageList=iTestService.findAllPaging ( 1,numRecordPage );
        model.addAttribute ( "totalPage" ,numPage);
        model.addAttribute ( "currentPage",1 );
        model.addAttribute ( "ListTest",pageList );
        return "TestManager";
    }
    @RequestMapping("/create-test")
    public String createTest(ModelMap model) {
        return "CreateTest";
    }
    @GetMapping("/create-test/AddTest")
    public String addTest(ModelMap model, @RequestParam String testName,@RequestParam String description,@RequestParam Integer testTime,
                          @RequestParam Integer questionNumber,@RequestParam String testType,@RequestParam String password) {
        Test test = new Test ();
        test.setTestName ( testName );
        test.setDescription ( description );
        test.setQuestionNumber ( questionNumber );
        test.setTestTime ( testTime );
        test.setActive ( 0 );
        test.setTestId ( "" );
        test.setPassWord ( password );
        test.setTestType ( iTestTypeService.getByTypeName ( testType ) );
        iTestService.saveTest ( test );
        return "redirect:/test-manager";
    }
    @RequestMapping("/test-manager/page")
    public  String paging(@RequestParam Integer page, @RequestParam Integer limit, ModelMap model){
        Integer numAll=iTestService.getNumTest ();
        Integer numRecordPage=3;
        Integer numPage=0;
        if(numAll%numRecordPage==0)
            numPage=(numAll/numRecordPage);
        else
            numPage=(numAll/numRecordPage)+1;
        List<Test>  pageList=iTestService.findAllPaging ( page,numRecordPage );
        model.addAttribute ( "totalPage" ,numPage);
        model.addAttribute ( "currentPage",page );
        model.addAttribute ( "ListTest",pageList );
    return "TestManager";
    }
    @RequestMapping("/test-manager/add-question")
    public  String addQuest(@RequestParam String idTest,ModelMap model){
        List<Question> questionList= iQuestionService.findAllQuestion ();
        model.addAttribute ( "idTest",idTest );
        model.addAttribute ( "questions",questionList );
        return "AddQuestion";
    }

    @RequestMapping("/test-manager/add-question/add")
    public  String addQuestToTest(@RequestParam String idTest,@RequestParam List<Integer> questionId){
        Set<Question> questions= iQuestionService.findByListId ( questionId );
        iTestService.saveQuestion ( questions,idTest );
        return "redirect:/test-manager";
    }

}
