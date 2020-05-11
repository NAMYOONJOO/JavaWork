import java.util.Scanner;
public class dd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a,b;
		System.out.println("두 수를 입력하세요");
		a= sc.nextInt();
		b= sc.nextInt();
		if(a%2==0) {
			System.out.println("\""+a+"\""+"는 2의 배수입니다");
			if(b%2==0) System.out.println("\""+b+"\""+"는 2의 배수입니다");
			else System.out.println("\""+b+"\""+"는 2의 배수가 아닙니다");
		}
		else {
			System.out.println("\""+a+"\""+"는 2의 배수가 아닙니다");
			if(b%2==0) System.out.println("\""+b+"\""+"는 2의 배수입니다");
			else System.out.println("\""+b+"\""+"는 2의 배수가 아닙니다");
		}
	}

}
