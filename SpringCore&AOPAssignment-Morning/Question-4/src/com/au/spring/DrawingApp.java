package com.au.spring;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) throws IOException {
		
		
		
		
		ApplicationContext config = new AnnotationConfigApplicationContext(AppConfig.class);
		Rectangle rectangle = (Rectangle) config.getBean("rectangle");
		rectangle.draw();

	}

}

