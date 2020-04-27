package com.lec.java.crawl13;
/*
 * Jackson 라이브러리
 * 	Java Object를 JSON으로 변환하거나 JSON을 Java Object로 변환하는데 사용할 수 있는 Java 라이브러리입니다.
 * 		Jackson Github - https://github.com/FasterXML/jackson
 * 
 * Jackson 특징
 * 	1.Stream API : 스트림 형식으로 데이터를 분석하고 생성하기 때문에 성능이 좋습니다.
 * 	2.Tree Model : XML의 DOM 처럼 Node 형태로 데이터를 다룰 수 있기 때문에 유연성이 좋습니다.
 * 	3.Data Binding : POJO 기반의 자바 객체들을 JSON으로 변환시킬 수 있습니다.
 * 
 * Maven 설정
 * 	jackson-databind 라이브러리는 jackson-core 및 jackson-annotation 라이브러리의 의존성을 포함하기 때문에 메이븐을 사용하는 경우 jackson-databind 라이브러리만 추가해주시면 됩니다.
 * 
 * MVNrepository :
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations

 *
 * 자바스크립트의 배열 ↔ 자바의 List<>
 * 자바스크립트의 object ↔ 자바의 객체(class)
 *
 *
 *
 *
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Crawl13Main {

	public static void main(String[] args) {
		System.out.println("jackson-databind 사용");
		User user = new User();
		user.setName("윤둥이");
		user.setAge(20);
		user.setScore1(new Score(20,30,100));
		List<String> list = new ArrayList<String>();
		list.add("JSON 은 Javascript Object Notation 의 약자입니다");
		list.add("JSON 은 데이터 교환 포맷으로 인기 짱입니다");
		list.add("JSON 은 배열이 있습니다 (XML보다 장점!)");
		list.add("JSON 은 타입 검증에 대해선 XML보다 약합니다");
		user.setMessages(list);
		
		
		javaToJson(user);
		jsonToJava(); 
		
		System.out.println("\n프로그램 종료");
	}
	public static void javaToJson(User user) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			//javar 객체(user) -> json(user.json파일)
			mapper.writeValue(new File("data/user.json"),user);
			
			
			//java 객체 ->json문자열
			System.out.println(mapper.writeValueAsString(user));
			
			
			//json문자열 변환시 이쁜 포맷(?)
			
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("data/myuser.json"), user);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//json---->자바객체
	public static void jsonToJava() {
		ObjectMapper mapper = new ObjectMapper();
		//json파일 ---->자바객체
		try {
			//User라는 클래스 객체로 변환
			//User객체타입으로 반환
			User user1 = mapper.readValue(new File("data/user.json"), User.class);
			System.out.println(user1);
//			URL url = new URL("http://openapi.seoul.go.kr:8088/6561536751626864373042464d4356/json/CardSubwayStatsNew/1/5/20181001");
//			
//			Subway subway = mapper.readValue(url, Subway.class);
//			System.out.println(subway.CardSubwayStatsNew.list_total_count);		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}
