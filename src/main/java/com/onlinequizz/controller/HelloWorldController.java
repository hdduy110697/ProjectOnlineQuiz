package com.onlinequizz.controller;

import com.onlinequizz.Entity.Test;
import com.onlinequizz.Service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {
	@Autowired
	ITestService iTestService;
	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		return "redirect:/test-manager";
	}




}