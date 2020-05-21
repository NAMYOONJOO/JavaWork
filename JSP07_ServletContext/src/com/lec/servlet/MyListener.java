package com.lec.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	
	//두개의 메소드 오버라이딩 합니다.  contextDestroyed contextInitialized
	
	//웹 어플리케이션(컨텍스트) 종료할 때 호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("JSP07 어플리케이션 종료");
		
	}
	//웹 어플리 케이션 (컨텍스트) 시작할 때 호출
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("JSP07 어플리케이션 시작");
	}
}

//web.xml 에 등록해야지 동작한다. 
//<listener>
//<listener-class>
//com.lec.servlet.MyListener
//</listener-class>
//</listener>
//이렇게