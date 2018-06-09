package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.close();

	}

}
