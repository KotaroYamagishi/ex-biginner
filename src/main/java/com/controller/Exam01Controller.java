package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.form.Exam01Form;

@Controller
@RequestMapping("/ex01")
public class Exam01Controller {

	@ModelAttribute
	public Exam01Form setUpForm() {
		return new Exam01Form();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam01";
	}
	
	@RequestMapping("/ex01-result")
	public String result(Model model,Exam01Form form) {
		String name=form.getName();
		model.addAttribute("name", name);
		
		return "exam01-result";
	}
}
