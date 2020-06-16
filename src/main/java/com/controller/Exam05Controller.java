package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Member;
import com.form.Exam05Form;
import com.repository.Exam05Repository;

@Controller
@Transactional
@RequestMapping("/ex05")
public class Exam05Controller {

	@ModelAttribute
	public Exam05Form setUpForm() {
		return new Exam05Form();
	}
	
	@Autowired
	private Exam05Repository repository;
	
	@RequestMapping("")
	public String index() {
		return "exam05";
	}
	
	@RequestMapping("/ex05-result")
	public String result(Model model,Exam05Form form) {
		
		List<Member> memberList;
		memberList=repository.findByName(form.getName());
		
		memberList.forEach(i->System.out.println(i.getName()));
		model.addAttribute("memberList", memberList);
		return "exam05-result";
	}
}
