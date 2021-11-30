package com.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

	private int id;
	private String name;
	private Address address;
	
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


	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void display() {
		//log.info("Hello!!! "+name);
		System.out.println("Hello!!! "+id+" "+name);
		System.out.println(address);
	}
	
}
