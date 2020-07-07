package com.lec.spring.autowired3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowiredMain3 {

	public static void main(String[] args) {

		
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("--컨테이너생성--");
		
		System.out.println(ctx.getBean("plusop"));

		ctx.close();
		
		System.out.println("종료");
	}

}
