package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

	private int id;
	private String name;
	private int age;
	private long salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name= "+name+
				" emp id= "+id+" Age= "+age+" salary= "+salary;
	}
	
}
