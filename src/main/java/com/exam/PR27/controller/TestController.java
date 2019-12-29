/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.controller;

import com.exam.PR27.Dao.QuestionDao;
import com.exam.PR27.Dao.TestDao;
import com.exam.PR27.Dao.TestTypeDao;
import com.exam.PR27.dto.TestAddQuestionDto;
import com.exam.PR27.dto.TestDto;
import com.exam.PR27.entity.Question;
import com.exam.PR27.entity.Test;
import com.exam.PR27.entity.TestType;
import com.exam.PR27.validation.TestAddQuestionValidation;
import com.exam.PR27.validation.TestValidation;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author HoangMinh
 */
@Controller
public class TestController {

    @Autowired
    private TestDao testService;
    @Autowired
    private TestTypeDao testTypeService;
    @Autowired
    private QuestionDao questionService;
    @Autowired
    private TestValidation testValidation;
    @Autowired
    private TestAddQuestionValidation addQuestionValidation;

    @GetMapping("/test/list")
    public String listQuestion(Model model, HttpServletRequest request) {

        int page = 0;
        int size = 3;
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        Page<Test> list = testService.findAll(PageRequest.of(page, size));
        model.addAttribute("list", list);
        return "/user/listTest";
    }

    @GetMapping("/test/create")
    public String createTest(Model model) {
        TestDto testDto = new TestDto();
        List<TestType> listTestType = testTypeService.findAll();
        model.addAttribute("testDto", testDto);
        model.addAttribute("listTestType", listTestType);
        return "/user/createTest";
    }

    @GetMapping("/test/edit")
    public String createTest(@RequestParam(name = "id") int id, Model model) {
        TestDto testDto = new TestDto();
        Test test = testService.findById(id).get();
        testDto.setTestTime(test.getTestTime());
        testDto.setDescription(test.getDescription());
        testDto.setQuestionNumber(test.getQuestionNumber());
        testDto.setTestName(test.getTestName());
        testDto.setPassword(test.getPassword());
        testDto.setId(test.getId());
        List<TestType> listTestType = testTypeService.findAll();
        model.addAttribute("testDto", testDto);
        model.addAttribute("listTestType", listTestType);
        return "/user/createTest";
    }

    @GetMapping("/test/delete")
    public String deleteTest(@RequestParam(name = "id") int id) {
        testService.deleteById(id);

        return "redirect:/test/list";
    }

    @PostMapping("/test/save")
    public String saveTest(@ModelAttribute("testDto") TestDto testDto,
            Model model, BindingResult bindingResult) {
        testValidation.validate(testDto, bindingResult);
        if (bindingResult.hasErrors()) {
            List<TestType> listTestType = testTypeService.findAll();
            model.addAttribute("listTestType", listTestType);
            return "/user/createTest";
        }
        Test test = new Test();
        test.setDescription(testDto.getDescription());
        test.setPassword(testDto.getPassword());
        test.setTestName(testDto.getTestName());
        test.setTestTime(testDto.getTestTime());
        test.setQuestionNumber(testDto.getQuestionNumber());
        test.setTestType(testTypeService.findById(testDto.getTestTypeId()).get());
        if (testDto.getId() != 0) {
            test.setId(testDto.getId());
        }
        test = testService.save(test);
        return "redirect:/test/list";

    }

    @GetMapping("/test/addQuestion")
    public String addQuestion(@RequestParam(name = "id") int id, Model model) {

        Test test = testService.findById(id).get();
        List<Question> listQuestion = questionService.findAll();
        List<Integer> listQuestionTestId = new ArrayList<>();
        for (Question question : test.getQuestion()) {
            listQuestionTestId.add(question.getId());
        }
        TestAddQuestionDto testAddQuestionDto = new TestAddQuestionDto();
        testAddQuestionDto.setTestId(test.getId());
        testAddQuestionDto.setListQuestionId(listQuestionTestId);
        model.addAttribute("listQuestion", listQuestion);
        model.addAttribute("testAddQuestionDto", testAddQuestionDto);
        return "/user/addQuestionTest";
    }

    @PostMapping("/test/addQuestion")
    public String saveQuestionTest(@ModelAttribute("testAddQuestionDto") TestAddQuestionDto testAddQuestionDto,
            Model model, BindingResult bindingResult) {
        addQuestionValidation.validate(testAddQuestionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            Test test = testService.findById(testAddQuestionDto.getTestId()).get();
            List<Question> listQuestion = questionService.findAll();
            List<Integer> listQuestionTestId = new ArrayList<>();
            for (Question question : test.getQuestion()) {
                listQuestionTestId.add(question.getId());
            }
            testAddQuestionDto.setTestId(test.getId());
            testAddQuestionDto.setListQuestionId(listQuestionTestId);
            model.addAttribute("listQuestion", listQuestion);
            model.addAttribute("testAddQuestionDto", testAddQuestionDto);

            return "/user/addQuestionTest";
        }
        Test test = testService.findById(testAddQuestionDto.getTestId()).get();
        List<Question> listQuestion = new ArrayList<>();
        for (int i = 0; i < testAddQuestionDto.getListQuestionId().size(); i++) {
            listQuestion.add(questionService.findById(testAddQuestionDto.getListQuestionId().get(i)).get());
        }
        test.setQuestion(listQuestion);
        test = testService.save(test);
        return "redirect:/test/list";
    }
}
