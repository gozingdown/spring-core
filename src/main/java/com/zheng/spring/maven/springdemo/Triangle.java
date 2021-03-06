package com.zheng.spring.maven.springdemo;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements Shape, ApplicationContextAware, BeanNameAware {

	// public void afterPropertiesSet() throws Exception {
	// System.out.println("InitializingBean init method called for Triangle");
	// }
	//
	// public void destroy() throws Exception {
	// System.out.println("DisposableBean destroy method called for Triangle");
	// }

	// use this to avoid using spring specific interfaces
	public void myInit() {
		System.out.println("My init method called for Triangle");
	}
	
	public void cleanUp() {
		System.out.println("cleanUp method called for Triangle");
	}

	private List<Point> points;
	private ApplicationContext context = null;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		for (Point point : points) {
			System.out.println("Point = (" + point.getX() + ", " + point.getY() + ")");
		}
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}

	public void setBeanName(String name) {
		System.out.println("Bean name is: " + name);
	}
}
