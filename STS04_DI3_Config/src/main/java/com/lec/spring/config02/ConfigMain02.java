package com.lec.spring.config02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lec.beans.Score;

public class ConfigMain02 {
	public static void main(String[] args) {
	
		//'Java 설정파일' 사용한  컨텍스트 생성
		AnnotationConfigApplicationContext ctxA = 
				new AnnotationConfigApplicationContext(AppConfig02.class);
		
		System.out.println("--ctxA 생성--");
		Score score1 = null;
		score1 = ctxA.getBean("score1",Score.class);
		System.out.println(score1);
		
		System.out.println(ctxA.getBean("stu1"));
		
		ctxA.close();
		
		
		
	}
}
