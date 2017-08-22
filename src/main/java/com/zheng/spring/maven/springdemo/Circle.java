package com.zheng.spring.maven.springdemo;

import javax.annotation.Resource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {
	
	// spring is going to call this method, you can also autowire the publisher member variable, but this is best practice.
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	private Point center;
	
	@Autowired //autowire by type
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	
//	public MessageSource getMessageSource() {
//		return messageSource;
//	}
//
//	public void setMessageSource(MessageSource messageSource) {
//		this.messageSource = messageSource;
//	}

	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[]{center.getX(), center.getY()}, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("greeting", null, "Default Greeting", null));
		DrawEvent drawEvent = new DrawEvent(this);
		this.publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

	@Resource(name="pointC") //dependency injection by name
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of Circle");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy of Circle");
	}

}
