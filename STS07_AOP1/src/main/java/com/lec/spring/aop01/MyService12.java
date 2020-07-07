package com.lec.spring.aop01;

import com.lec.beans.Logger;
import com.lec.beans.Service;

public class MyService12 extends Service {

	@Override
	public void doAction() {
		new Logger().logIn();// 공통기능
		
		//핵심기능
		System.out.println("MySercice11의 doAction()");
		
		new Logger().logIn();// 공통기능
	}

}
