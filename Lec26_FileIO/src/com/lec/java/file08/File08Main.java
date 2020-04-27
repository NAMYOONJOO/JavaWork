package com.lec.java.file08;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* Object Filter Stream
 Program <=== ObjectInputStream <=== FileInputStream <=== File
 Program ===> ObjectOutputStream ===> FileOutputStream ===> File

java.lang.Object
 └─ java.io.OutputStream
    └─ java.io.ObjectOutputStream
 
java.lang.Object
 └─ java.io.InputStream
     └─ java.io.ObjectInputStream


 Object Stream: 객체의 입출력을 위한 스트림
 사용법은 다른 Filter Stream(Buffered I/O, Data I/O)과 비슷
 Object 스트림의 입출력 대상이 되는 클래스는 Serializable 인터페이스를 구현
 클래스의 일부 멤버 변수를 직렬화(Serialization)의 대상에서 제외시키려면,
 transient 키워드를 사용
*/
public class File08Main {
	
	public static final String FILEPATH  = "temp/member.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				InputStream in = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in);
				
				){
			Member m1 = new Member("root", "root1234");
			Member m2 = new Member("guest", "guest");
			Member m3 = new Member("admin", "admin123456");
			
			oout.writeObject(m1);
			oout.writeObject(m2);
			oout.writeObject(m3);
			
			//파일에서 Object타입으로 읽기
			Member dataRead;
			
			//읽는방법1: 매번 readObject() 호출
//			dataRead = (Member) oin.readObject(); //num과 Exist는 저장이 안되게(transient) 설정했기때문에 기본값 0, false가 출력된다. 
//			dataRead.displayInfo();
//			dataRead = (Member) oin.readObject();
//			dataRead.displayInfo();
//			dataRead = (Member) oin.readObject();
//			dataRead.displayInfo();

			
			//읽는방법2 : 무한루프로  readObject() 호출
			//EOFException 으로 잡기
			//EOF : end of file
			
			while(true) {
				dataRead = (Member) oin.readObject();
				dataRead.displayInfo();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {//따로 추가
			System.out.println("파일 끝까지 읽었습니다.");
		} catch(IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		

		// TODO
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















