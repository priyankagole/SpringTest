package com.example.model;

import java.util.logging.Logger;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestMain {

	Logger log= Logger.getLogger(Student.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Resource rs= new ClassPathResource("application-context.xml");
		 * 
		 * BeanFactory factory=new XmlBeanFactory(rs);
		 */
		
		ApplicationContext app = new ClassPathXmlApplicationContext("application-context.xml");
		
		Student s= (Student)app.getBean("studentBean");
		s.display();
	}

}
