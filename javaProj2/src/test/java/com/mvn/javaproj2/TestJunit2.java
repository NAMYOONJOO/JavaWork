package com.mvn.javaproj2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestJunit2 extends TestCase{

	@Before
	public void before() {
		System.out.println("before()");
	}
	@After
	public void after() {
		System.out.println("after()");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("beforeClass()");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("afterClass()");
	}
	
	@Test
	public void testA() {
		System.out.println("testA()");
		System.out.println("No. of Test Case = "+this.countTestCases());
		System.out.println("Test Case Name = "+this.getName());
	}
	@Test
	public void testB() {
		System.out.println("testB()");
		System.out.println("No. of Test Case = "+this.countTestCases());
		setName("Btest 입니다. ");
		System.out.println("Test Case Name = "+this.getName());
	}
	@Test
	public void testC() {
		System.out.println("testC()");
		System.out.println("No. of Test Case = "+this.countTestCases());
		System.out.println("Test Case Name = "+this.getName());
	}
	@Test
	public void testD() {
		System.out.println("testD()");
		System.out.println("No. of Test Case = "+this.countTestCases());
		System.out.println("Test Case Name = "+this.getName());
	}

}
