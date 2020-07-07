package com.lec.spring.aop01;

import com.lec.beans.Logger;
import com.lec.beans.Service;

public class MyService11 extends Service {

	@Override
	public void doAction() {
		new Logger().logIn();// 공통기능
		
		//핵심기능
		System.out.println("MySercice12의 doAction()");
		
		new Logger().logIn();// 공통기능
	}

}
