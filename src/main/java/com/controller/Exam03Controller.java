package com.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.form.Exam03Form;

@Controller
@RequestMapping("/ex03")
public class Exam03Controller {

	@Autowired
	private ServletContext application;
	
	@ModelAttribute
	public Exam03Form setUpForm() {
		return new Exam03Form();
	}
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/ex03-result")
	public String result(Exam03Form form) {
		Integer item1=form.getItem1();
		Integer item2=form.getItem2();
		Integer item3=form.getItem3();
		
		Integer total=item1+item2+item3;
		Integer newTotal=(int) (total*1.1);
		
		application.setAttribute("total", total);
		application.setAttribute("newTotal", newTotal);
		
		return "exam03-result";
	}
	
}
