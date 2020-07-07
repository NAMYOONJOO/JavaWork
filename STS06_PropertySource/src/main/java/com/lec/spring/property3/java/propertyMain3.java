package com.lec.spring.property3.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lec.spring.property2.xml.DBConn;

public class propertyMain3 {

	public static void main(String[] args) {
		      AnnotationConfigApplicationContext ctx =
		            new AnnotationConfigApplicationContext(DBConfig.class);
		      System.out.println("-- ctx 생성 --");
		      
		      DBConn conn = ctx.getBean("dbConfig",DBConn.class);
		      
		      System.out.println("id : "+conn.getId());
		      System.out.println("pw : "+conn.getPw());
		      System.out.println("url : "+conn.getUrl());
		      System.out.println("port : "+conn.getPort());
		      
		      ctx.close();
	}

}
