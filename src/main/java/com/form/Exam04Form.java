package com.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Exam04Form {

	@NotBlank(message = "入力して")
	private String name;
	@NotNull(message = "入力して")
	private Integer age;
	@NotBlank(message = " 入力して")
	private String comment;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
