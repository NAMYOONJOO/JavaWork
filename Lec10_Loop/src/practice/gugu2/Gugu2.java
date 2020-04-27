package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {

		int dan, cnt;
		for (dan = 2; dan <= 9; dan += 3) {
			for (cnt = 1; cnt <= 9; cnt++) {
				for (int i = 1; i <= 3; i++) {
					if (dan <= 9) {
						System.out.print(dan + " x " + cnt + " =  " + (dan * cnt) + "\t");
					}
					dan++;
				}
				dan -= 3;
				System.out.println();
			}
			System.out.println();
		}

	}

}
