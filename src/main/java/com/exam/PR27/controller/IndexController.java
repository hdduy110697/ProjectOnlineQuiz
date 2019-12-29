/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam.PR27.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author HoangMinh
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "redirect:/test/list";
    }
}
