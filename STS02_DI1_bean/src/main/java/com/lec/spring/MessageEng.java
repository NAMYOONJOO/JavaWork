package com.lec.spring;

public class MessageEng implements MessageBean {

	String msgEng = "Good Morning";

	public MessageEng() {
		System.out.println("MessageEng() 생성");
	}

	@Override
	public void sayHello() {

		System.out.println(msgEng);
	}

}
