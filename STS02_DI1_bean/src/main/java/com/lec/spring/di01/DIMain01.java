package com.lec.spring.di01;

import com.lec.spring.MessageBean;
import com.lec.spring.MessageEng;
import com.lec.spring.MessageKor;

// Dependency Injection (DI, 의존 주입)
// 필요한 객체를 '누가' 만들어 사용하나
// 방법1 : 직접 생성 (new)하여 사용

public class DIMain01 {

	public static void main(String[] args) {
		System.out.println("메인 시작");
		MessageBean msg = null;

//		//필요한 MessageBean 객체를
//		msg = new MessageKor(); //직접 만들어 (new)사용
//		msg.sayHello();

		//의존하고 있던 객체의 버전등이 업그레이드 되면 (설계변경이 되면)
		//의존하고 있던 객체를 재컴파일 해야 한다. (수정해야 한다. !)
		msg = new MessageEng();
		msg.sayHello();
		
		System.out.println("메인 종료");
	}

}
