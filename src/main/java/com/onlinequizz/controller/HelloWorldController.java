package com.onlinequizz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("greeting", "Hello World ");
		return "welcome";
	}


	@RequestMapping(value = "create-question", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World ");
		return "createquestion";
	}

}