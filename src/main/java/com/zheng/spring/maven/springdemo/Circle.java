package com.zheng.spring.maven.springdemo;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape{

	private Point center;
	
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Drawing Circle");
		System.out.println("Circle: Point is ("+ center.getX() + ", " + center.getY() + ")");
	}

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

}
