package com.lec.spring.property2.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class propertyMain2 {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:appCtx2.xml");
		System.out.println("--ctx생성--");
		
		DBConn conn = ctx.getBean("dbConnection",DBConn.class);
		System.out.println("admin.id : "+conn.getId());
		System.out.println("admin.pw : "+conn.getPw());
		System.out.println("db.url : "+conn.getUrl());
		System.out.println("db.port : "+conn.getPort());
		
		ctx.close();
	}

}
