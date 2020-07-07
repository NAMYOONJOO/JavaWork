package com.lec.spring.config01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Score;

public class ConfigMain01 {

	public static void main(String[] args) {
		AbstractApplicationContext ctxA = 
				new GenericXmlApplicationContext("classpath:appCtx01_A.xml");
		
		System.out.println("== ctxA 생성 ==");
		
		Score score1 = (Score)ctxA.getBean("score1");
		System.out.println(score1);
		
		//컨텍스트 객체는 여러개 만들 수 있다.
		AbstractApplicationContext ctxB = 
				new GenericXmlApplicationContext("classpath:appCtx01_B.xml");
		
		System.out.println("== ctxB 생성 ==");
		
		Score score2 = (Score)ctxB.getBean("score2");
		System.out.println(score2);
		
		
		//심지어 여러개의 설정파일로부터 컨텍스트 생성가능
		AbstractApplicationContext ctxAB = 
				
				new GenericXmlApplicationContext(
//						"classpath:appCtx01_A.xml","classpath:appCtx01_B.xml");
						"classpath:appCtx01_B.xml","classpath:appCtx01_A.xml");
		System.out.println("== ctxAB 생성 ==");
		
		Score score1_2 = ctxAB.getBean("score1",Score.class);
		Score score2_2 = ctxAB.getBean("score2",Score.class);
		
		System.out.println(score1_2);
		System.out.println(score2_2);
		
		//다음 두개는 같다? 다르다?
		if(score1==score1_2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다.");
		}
		//결국 다른 컨테이너에 생성된 별개의 객체!
		ctxA.close();
		ctxB.close();
		ctxAB.close();
		
		
	}

}
