package ex3_1;

public class Operand {
	int value;

	public Operand() {
		super();
		System.out.println("Operand() 기본생성자 생성");
	}
	public Operand(int value) {
		super();
		this.value = value;
		System.out.printf("Operand(%d) 생성자 생성",value);
	}



	
}
