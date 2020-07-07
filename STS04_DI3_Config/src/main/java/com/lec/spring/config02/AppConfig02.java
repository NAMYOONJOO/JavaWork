package com.lec.spring.config02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.beans.Score;
import com.lec.beans.Student;

//Java 클래스를 이용한 설정
//클래스 이름앞에 반드시 어노테이션 명시 필요
//@configuration --> 이 클래스는 '스프링 설정'에 사용되는 클래스 입니다.
//결국 컨테이너 역할을 함.

@Configuration
public class AppConfig02 {
	
	@Bean
	public Score score1() { //메소드 이름 score1이 bean의 네임값 (아이디)가 된다. 
		return new Score(100,85,75,"나빠요");	
	}
	
	@Bean
	public Student stu1() {
		return new Student("훈지예찌",34,score1());
	}
}
