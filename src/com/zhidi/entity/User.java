package com.zhidi.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {

	private  String name;
	private  Integer age;
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private  Date  bithday;
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", bithday=" + bithday
				+ "]";
	}
	public Date getBithday() {
		return bithday;
	}
	public void setBithday(Date bithday) {
		this.bithday = bithday;
	}
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
	
	
}
