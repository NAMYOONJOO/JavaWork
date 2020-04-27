package com.lec.java.operator09;
/* 산술 연산의 결과 타입
 * 
 * 일단 피연산자가 reference type 이면, unbox 후 형변환 수행됨. 그리고 나서
 * 피연산자중 하나라도 double 이면 다른쪽이 double 이 된다.  
 * 그렇지 않으면 피연산자중 하나라도 float 이면 다른 쪽이 float 가 된다.  
 * 그도 아니면 피연산자중 하나라도 long 이면 다른 쪽을 long 으로 바꾼다.  
 * 그도 아니면 양쪽 피연산자 모~ 두 int 로 바꾼다.
 * 
 * https://docs.oracle.com/javase/specs/#5.6.2
 * 	When an operator applies binary numeric promotion to a pair of operands, each of which must denote a value that is convertible to a numeric type, the following rules apply, in order, using widening conversion (§5.1.2) to convert operands as necessary: 
 * 	If any of the operands is of a reference type, unboxing conversion (§5.1.8) is performed. Then: 
 * 	If either operand is of type double, the other is converted to double. 
 * 	Otherwise, if either operand is of type float, the other is converted to float. 
 * 	Otherwise, if either operand is of type long, the other is converted to long. 
 * 	Otherwise, both operands are converted to type int.
 */
public class Operator09Main {

	public static void main(String[] args) {
		System.out.println("산술연산의 결과 타입");


		int n1 = 10, n2 =20;
		int n3 = n1 + n2;
		System.out.println("n3 : " +n3);
		
		byte b1 = 10;
		byte b2 = 20;
//		byte b3 = b1 + b2;// byte+ byte -> int 타입
		
		short s1 = 10, s2 = 20;
		//short s3 = s1 +s2; // short + short ->int
		
		//short s3 = b1 + s1;  //byte + short ->int
		// 이런경우가  char 의 경우에도 발생한다. 
		
		char ch1 = 10, ch2 = 20;
		//char ch3 = ch1 + ch2; // char + char-> int
		char ch3 = (char)(ch1+ch2); // 따라서 명시적 형변환
		
		
		long l1 = 10L;
		//int m4 = m1 + l1; // int + long -> long
		
		float f1 = 1.0f, f2 = 2.0f;
		float f3 = f1 + f2; // OK
		f3 = f1 + n1; //OK
		f3 = f1 + b1; //OK
		
		double d1= 1.0, d2 = 2.0;
		double d3 = d1 + d2; //OK
		d3 = d1 + f1;//OK // double 끼리의 연산은 double 이 나온다 
		
		//f3 = f1 +d1; //float + double --> double
		
		// int 이하 끼리 연산 결과 무조건 int 이기 때문에 주의 !
		long l2 = 27000000000L;
		System.out.println("l2 : "+ l2);
		
		l2 = 3000*3000*3000;// int*int*int 이기 때문에 int의 결과를 벗어나지 못한다. 
		System.out.println("l2 : "+ l2);//******위와 결과가 다르다 

		// 자바의 연산결과 타입규칙과 
		// 기본데이터 타입의 한계값 인지하고 있어야 한다. 
		
		
		
		// 복합대입 연산자 
		
		int sum = 0;
		double d4 = 1.2;
		//sum = sum +d4;  에러
		sum += d4; // 이건 OK?
		System.out.println(sum);
		
		// sum += d4 복합대입연산자는
		//   sum = sum + d4 가 아니라...
		//   sum = (int)(sum + d4)  으로 동작함
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class