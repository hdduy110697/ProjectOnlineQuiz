package com.onlinequizz.controller;

import com.onlinequizz.Entity.Test;
import com.onlinequizz.Service.ITestService;
import com.onlinequizz.Service.ITestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TestManagerController {
    @Autowired
    ITestService iTestService;
    @Autowired
    ITestTypeService iTestTypeService;
    @RequestMapping("/test-manager")
    public String testManager(ModelMap model) {
        List<Test> tests=iTestService.findAllTest ();
        model.addAttribute ( "ListTest",tests );
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

}
