/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.controller;

import com.exam.PR27.Dao.QuestionDao;
import com.exam.PR27.entity.Question;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/question/list")
    public String listQuestion(Model model) {
        List<Question> list = questionService.findAll();
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
        questionService.deleteById(id);
        return "redirect:/question/list";
    }
    
    
    
    
}