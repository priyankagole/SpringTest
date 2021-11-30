package com.example.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.beans.Address;
import com.example.beans.Student;

@Configuration
public class Config {

	public Config() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean
	public Student getStudent() {
		Student st= new Student();
		st.setId(10);
		st.setName("Lucy");
		return st;
	}
	
	@Bean(name="add")
	public Address getAddress() {
		Address add= new Address();
		add.setCity("mumbai");
		add.setState("maharashtra");
		add.setCountry("india");
		return add;
	}
	@Bean(name = "address1")
	public Address getAddress1() {
		Address add= new Address();
		add.setCity("mumbai1");
		add.setState("maharashtra");
		add.setCountry("india");
		return add;
	}

}
