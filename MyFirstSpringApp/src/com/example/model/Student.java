package com.example.model;

import java.util.logging.Logger;

public class Student {
	Logger log= Logger.getLogger(Student.class);
	private int id;
	private String name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public void display() {
		log.info("Hello!!! "+name);
		e.printStacktrace();
		//System.out.println("Hello!!! "+name);
	}
	
}
