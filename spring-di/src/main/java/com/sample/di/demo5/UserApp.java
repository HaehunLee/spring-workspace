package com.sample.di.demo5;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserApp {

	public static void main(String[] args) {
		String resource = "classpath:/com/sample/di/demo5/user.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
		
		UserService s1 = ctx.getBean("service", UserService.class);
		
		s1.addNewUser("이해훈", "gnsl1102", "zxcv1234");
	}
}
