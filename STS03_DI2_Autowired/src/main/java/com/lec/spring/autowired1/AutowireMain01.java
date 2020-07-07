package com.lec.spring.autowired1;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowireMain01 {

	public static void main(String[] args) {
		System.out.println("Autowired 자동 주입");

		
		GenericXmlApplicationContext ctx =  new GenericXmlApplicationContext("classpath:autowiredCtx1.xml");
		System.out.println("---컨테이너생성---");
		System.out.println(ctx.getBean("regService"));
		System.out.println(ctx.getBean("readService"));
		System.out.println(ctx.getBean("updateService"));//DAO를 지정해주지 않아서  NullPointException
		System.out.println(ctx.getBean("deleteService"));
		ctx.close();
		System.out.println("종료");
	}

}
