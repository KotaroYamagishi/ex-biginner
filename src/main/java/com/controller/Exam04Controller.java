package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.User;
import com.form.Exam04Form;

@Controller
@Validated
@RequestMapping("/ex04")
public class Exam04Controller {

	@ModelAttribute
	public Exam04Form setUpForm() {
		return new Exam04Form();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam04";
	}
	
	@RequestMapping("/ex04-result")
	public String result(Model model,@Validated Exam04Form form,BindingResult result) {
		if(result.hasErrors()) {
			return index();
		}
		
		User user=new User();
		user.setName(form.getName());
		user.setAge(form.getAge());
		user.setComment(form.getComment());
		
		model.addAttribute("user", user);
		
		return "exam04-result";
	}
}
