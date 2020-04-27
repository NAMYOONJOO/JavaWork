package phonebook01.class01;

import java.util.Scanner;

public class PhonebookMain {

	Scanner sc;
	PhonebookModel[] bookData = new PhonebookModel[5];

	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init();// 초기화
		app.run();// 실행
		app.exit();// 종료
	}

	// 응용 프로그램을 초기화
	public void init() {
		sc = new Scanner(System.in);
	}

	// 응용프로그램 구동
	public void run() {
		System.out.println("전화번호부 v1.0");
		while (true) {
			showMenu();

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				System.out.println("전화번호부를 입력합니다.");
				insertPhoneBook();
				break;
			case 2:
				System.out.println("전화번호부 출력(열람)");
				showPhoneBook();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
			}
		}//end while
	}//end run()

	// 응용프로그램 종료
	public void exit() {
		sc.close();
	}
	//전화번호부 입력
	public void insertPhoneBook() {
		int i;
		for ( i = 0; i < bookData.length; i++) {
			if(bookData[i]==null) {
				break;
			}
		}
		if(i==bookData.length) {
			System.out.println("꽉차떠염");
			return;
		}
		
		System.out.println("이름 입력:");
		String name = sc.nextLine();
		System.out.println("전화번호 :");
		String phoneNum = sc.nextLine();
		System.out.println("이메일 :");
		String email = sc.nextLine();
		PhonebookModel pb = new PhonebookModel(name,phoneNum,email);
		pb.setUid(i);
		bookData[i]=pb;
		System.out.println((i+1)+"번째 전화번호부 추가 완료!!!**");

		
		//전화번호부가 다 찼는지 체크
		// 다 찼으면 입력불가 처리
		
		// 이름, 전화번호, 이메일 입력을 받으세요
		// --->PhonebookMode1 인스턴스 생성
		
		// 배열에 추가
	}
	//전화번호부 출력
	public void showPhoneBook() {
		
		int cnt=0;
		for (int i = 0; i < bookData.length; i++) {
			if(bookData[i]==null) {
				cnt =i;
				break;
			}
			else {
				System.out.println(toString());
				
			}
		}
		
		
		System.out.println(cnt+"개의 전화번호부 출력");
		
		
		
	}

	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	}

}