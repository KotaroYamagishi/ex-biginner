package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.form.Exam02Form;

@Controller
@RequestMapping("/ex02")
public class Exam02Controller {

	@ModelAttribute
	public Exam02Form setUpForm() {
		return new Exam02Form();
	}
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("")
	public String index() {
		return "exam02";
	}
	
	@RequestMapping("/ex02-result")
	public String result(Exam02Form form) {
		Integer num1=form.getNum1();
		Integer num2=form.getNum2();
		Integer result=num1+num2;
		
		session.setAttribute("num1", num1);
		session.setAttribute("num2", num2);
		session.setAttribute("result", result);
		return "exam02-result";
		
	}
	
	@RequestMapping("/ex02-result2")
	public String result2() {
		return "exam02-result2";
	}
}
