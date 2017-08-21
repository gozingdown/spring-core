package com.zheng.spring.maven.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape{

	private Point center;
	
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Circle: Point is ("+ center.getX() + ", " + center.getY() + ")");
	}

	public Point getCenter() {
		return center;
	}

	//@Autowired //1. by type 2. if multiple bean found, by name 3. use @Qualifier
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

}
