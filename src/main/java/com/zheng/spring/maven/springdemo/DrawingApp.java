package com.zheng.spring.maven.springdemo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext context2 = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle)context.getBean("triangle");
		triangle.draw();
		Point pointD = (Point)context.getBean("pointD");
		Triangle triangle2 = (Triangle)context2.getBean("triangle");
		triangle2.setPointB(pointD);
		triangle2.draw();
		triangle.draw();
	}
}
