/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.controller;

import com.exam.PR27.Dao.QuestionDao;
import com.exam.PR27.Dao.TestDao;
import com.exam.PR27.entity.Question;
import java.util.List;

import com.exam.PR27.entity.Test;
import com.exam.PR27.validation.QuestionValidator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class QuestionController {

    @Autowired
    private QuestionDao questionService;

    @Autowired
    private TestDao testDao;
    @Autowired
    private QuestionValidator questionValidator;
    
    @GetMapping("/question/list")
    public String listQuestion(Model model ,HttpServletRequest request) {
        
        int page = 0; 
        int size = 3; 
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        Page<Question> list = questionService.findAll(PageRequest.of(page, size));
        model.addAttribute("list", list);
        return "/user/listQuestion";
    }
    
    
    @GetMapping("/question/create")
    public String createQuestion(Model model) {
        Question question = new Question();
        model.addAttribute("question", question);
        return "/user/createQuestion";
    }
    
    @PostMapping("/question/save")
    public String saveQuestion(@ModelAttribute("question") Question question,
            Model model, BindingResult bindingResult) {
        questionValidator.validate(question, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/user/createQuestion";
        }
        question = questionService.save(question);
        return "redirect:/question/list";
    }
    
    @GetMapping("/question/edit")
    public String editQuestion(@RequestParam(name = "id") int id, Model model) {
        Question question =questionService.findById(id).get();
        model.addAttribute("question", question);
        return "/user/createQuestion";
    }
    @GetMapping("/question/delete")
    public String deleteQuestion(@RequestParam(name = "id") int id) {
        Question question = questionService.findById ( id ).get ();
        for (Test t :
             question.getTest ()) {
            t.getQuestion ().remove ( question );
            testDao.save ( t );
        }
        question.getTest ().clear ();
        questionService.save (question );
        questionService.deleteById ( id );
        return "redirect:/question/list";
    }
    
}
