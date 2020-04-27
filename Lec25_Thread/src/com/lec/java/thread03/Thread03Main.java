package com.lec.java.thread03;

/* 쓰레드와 익명클래스
 */
public class Thread03Main {

	public static void main(String[] args) {
		System.out.println("쓰레드와 익명 클래스");
		
		// 이미 정의된 MyRunnable 클래스의 인스턴스 사용
		new Thread(new MyRunnable()).start();
		
		// 익명 클래스를 사용해서 Runnable 인스턴스를 생성
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ;i<10;i++) {
					System.out.println("3x " +i+" = "+(3*i));
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		for(int i = 0 ;i<10;i++) {
			System.out.println("4x " +i+" = "+(4*i));
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} // end main()

} // end class Thread03Main


class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i = 0 ;i<10;i++) {
			System.out.println("2x " +i+" = "+(2*i));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
} // end class MyRunnable

























