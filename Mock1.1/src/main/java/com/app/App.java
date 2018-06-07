package com.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.AppConfig;
import com.entity.Role;
import com.service.RoleService;

public class App {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		RoleService roleService = context.getBean(RoleService.class);

//		roleService.add(new Role(3,"Manager"));
		context.close();

	}

}
