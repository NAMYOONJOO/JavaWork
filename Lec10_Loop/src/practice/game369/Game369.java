package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		int num;
		int max_num = 100;
		for (num = 1; num <= max_num; num++) {
			if (num / 10 == 3 || num % 10 == 3 || num / 10 == 6 || num % 10 == 6 || num / 10 == 9 || num % 10 == 9) {
				System.out.print("*\t");
			} else {				
				System.out.print(num + "\t");
			}
			if (num % 10 == 0)System.out.println();
		}
	}
}
