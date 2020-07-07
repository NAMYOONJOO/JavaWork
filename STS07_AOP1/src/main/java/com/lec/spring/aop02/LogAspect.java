package com.lec.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.beans.Logger;

//Aspect : Advisor 들을 모아놓은 객체
//Avisor : Advice + Pointcut
//Advice : 공통기능

//이 클래스가 Aspect 역할을 할 클래스 임을 명시
@Aspect
public class LogAspect {

	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc1() {
	}

	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {
	}

	// Advisor 하나 구성
//   @Before("within(com.lec.spring.aop02.*)") //Pointcut
	@Before("pc1()")
	public void beforeAdvice() {
		System.out.println("[Before] ");
		new Logger().logIn(); // 공통코드. Advice!
	}

//   @After("within(com.lec.spring.aop02.*)")
//	@After("execution(* com.lec.spring.aop02.MyService22.*(..))")
//	@After("pc2()")
	@After("execution(* com.lec.spring.aop02.*2.*(..))")
	public void afterAdvice() {
		System.out.println("[After] ");
		new Logger().logOut();
	}

	// Around advice : 메소드 실행을 제어하는 가장 강력한 코드
	// 직접 해당 메소드를 호출하고 결과나 예외처리도 가능
	@Around("within(com.lec.spring.aop02.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// joinPoint 메소드 이름

		String signatureStr = joinPoint.getSignature().toShortString();

		// joinPoint 메소드 수행전
		System.out.println("[Around]" + signatureStr + "시작");
		long st = System.currentTimeMillis();// 시작시간 기록

		try {
			// joinPoint 메소드 수행
			Object obj = joinPoint.proceed();
			return obj;

		} finally {
			// joinPoint 메소드 수행후
			long et = System.currentTimeMillis();
			System.out.println("[Around]" + signatureStr + "종료, 경과시간 : " + (et - st));
		}

	}

}