package com.lec.spring.environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class EnvMain {

	public static void main(String[] args) {
		System.out.println("main 시작");
		// context->Environment->propertySources
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();// <--ConfigurableApplicationContext 소속 메소듸이다.
		MutablePropertySources propertySources = env.getPropertySources();

		// propertySources에 PropertySource 추가
		try {
			// PropertySource 하나를 생성하여 ProperySource 에 추가 : addLast() <--끝에 추가
			propertySources.addLast(new ResourcePropertySource("classpath:admin.auth"));

			// 이제 , Environment 를 통해 원하는 property에 접근 가능
			// 굳이 어느 PropertySource의 어느 Property 를 지정할 필요 없다
			// 어느 property 에 대한 것만 요청하면'
			// PropertySources 에 소속된 모든 PropertySource 들을 다 스캔해서 찾아낸다.
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
		} catch (IOException e) {

		}
		//ctx.load()<--안된다.
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("classpath:appCtx1.xml");//설정로딩
		gCtx.refresh();//빈생성
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection",AdminConnection.class);
		System.out.println("admin id : "+adminConnection.getAdminId());
		System.out.println("admin pw : "+adminConnection.getAdminPW());
	}

}
