package com.lec.java.exception04;

/*	예외 클래스의 상속 관계 (★필수 암기★)
	java.lang.Object
	|__ java.lang.Throwable
	  |
	  |__ java.lang.Exception  : 복구 가능
	  |    |
	  |    |__ java.lang.RuntimeException
	  |    |    |__ ArithmeticException, NullPointerException, ...
	  |    |
	  |    |__ IOException, ParseException ...
	  |
	  |__ java.lang.Error    : 복구 불가
	         ...   OutOfMemoryError, StackOverFlowError ...  
	
	 getMessage(), printStackTrace() 등의 메소드는 Throwable 클래스에 정의
	 자식 클래스들은 Throwable에 정의된 메소드들을 사용할 수 있음
	 
	catch문은 여러개를 사용할 수는 있지만, 
	 상위 예외 클래스를 하위 예외 클래스보다 먼저 사용할 수는 없다. (컴파일 에러) 
*/
public class Exception04Main {

	public static void main(String[] args) {
		System.out.println("try ~ catch ~ catch ");

		int num1 = 123, num2 = 10, result = 0;
		String str = "Abc";
		int[] numbers = new int[10];

		// TODO : try ~ catch ~ catch .. 사용
		try {
			result = num1 / num2;
			System.out.println("나눈 결과: " + result);

			int length = str.length();
			System.out.println("스트링 길이: " + length);
			str.charAt(20);// StringIndexOutOfBoundsException--->핸들링이 안됬기때문에 프로그램이 죽는다. (캐치 안됨) 
			numbers[9] = 11111;
			System.out.println("numbers: " + numbers[10]);
		} catch (ArithmeticException ex) {
			System.out.println("산술 예산 예외 : " + ex.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 index예외 : " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Null 포인터 : " + e.getMessage());
		} catch (Exception e) { //어떠한 Exception이 발생해도 전부catch한다. 
			//가장 밑에 적어야 한다. (조상)
			// Exception 은 모~든 Exception 들 (상속된 예외 객체들까지도) catch 할수 있다.
			// (다형성!)
			System.out.println("Exception발생");
		}
//		catch문은 여러개를 사용할 수는 있지만, 
//		 상위 예외 클래스를 하위 예외 클래스보다 먼저 사용할 수는 없다. (컴파일 에러) 

		System.out.println();
		System.out.println("프로그램 종료");

	} // end main()

} // end class Exception04Main
