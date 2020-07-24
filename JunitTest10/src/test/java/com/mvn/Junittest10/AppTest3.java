package com.mvn.Junittest10;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(value = Parameterized.class)
public class AppTest3 {

	
	private String expected ;
	private String value ;
	
	@Parameters
	public static Collection<String[]> getTestParameters(){
		return Arrays.asList(new String[][] {
			{"01033333333", "010-3333-3333"}, // expected, value
			{"20200707134044", "2020/07/07 13:40:44"}, // expected, value
			{"01045452424", "010.4545.2424"}, // expected, value
		});
	}

	public AppTest3(String expected, String value) {
		super();
		this.expected = expected;
		this.value = value;
	}

	//실습 3
//	@Parameters 를 사용하여 3개의 테스트 데이터로 테스트 수행하기
	@Test
	public void test() {

		App app = new App();
		assertEquals(expected, app.toNumber(value));
		System.out.println("테스트 통과 :"+expected+", "+value);
	}

}
