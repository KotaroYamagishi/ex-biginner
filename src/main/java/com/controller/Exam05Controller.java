package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ex05")
public class Exam05Controller {

	@RequestMapping("")
	public String index() {
		return "exam05";
	}
}
