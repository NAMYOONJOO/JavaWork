package com.lec.java.file06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*  Data Filter Stream
 Program <=== DataInputStream <=== FileInputStream <=== File
 Program ===> DataOutputStream ===> FileOutputStream ===> File

java.io.InputStream
|__ java.io.FilterInputStream
   |__ java.io.DataInputStream  

java.io.OutputStream
|__ java.io.FilterOutputStream
   |__ java.io.DataOutputStream
*/

public class File06Main {

	public static void main(String[] args) {
		System.out.println("Data Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream("temp/data.bin");
				DataOutputStream dout = new DataOutputStream(out);//장착
				
				InputStream in = new FileInputStream("temp/data.bin");
				DataInputStream din = new DataInputStream(in);//장착
				
				
				){
			
			dout.writeBoolean(true);//1byte
			dout.writeInt(100);//4byte
			dout.writeDouble(3.14);//8byte
			dout.writeChar('A');//2byte
			
			boolean b = din.readBoolean();
			System.out.println(b);
			int num = din.readInt();
			System.out.println(num);
			double num1 = din.readDouble();
			System.out.println(num1);
			char num2 = din.readChar();
			System.out.println(num2);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















