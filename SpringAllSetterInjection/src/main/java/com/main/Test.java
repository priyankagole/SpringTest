package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Student;


public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("application-context.xml");

		Student s = (Student) app.getBean("student");
		s.display();
		System.out.println(s);
		Student s1 = (Student) app.getBean("student");//return from cache
		s1.display();
		System.out.println(s1);
	}

}
