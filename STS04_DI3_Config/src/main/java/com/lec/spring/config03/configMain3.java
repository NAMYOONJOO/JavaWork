package com.lec.spring.config03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class configMain3 {

	public static void main(String[] args) {
//XML 설정으로부터 생성(XML안에 JAVA 설정 포함)
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx03.xml");

		System.out.println("==ctx 생성==");
		System.out.println(ctx.getBean("score1"));
		System.out.println(ctx.getBean("score2"));

	}

}
