package com.lec.java.test4;

import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int max = num;
		int min = num;
		while(true) {
			int num1 = sc.nextInt();
			if(num1==0)break;
			if(num1>max)max=num1;
			if(num1<min)min=num1;
		}
		System.out.println(max+" "+min);
		sc.close();
	}

}
 