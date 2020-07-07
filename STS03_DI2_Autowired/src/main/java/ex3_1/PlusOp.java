package ex3_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PlusOp implements OperatorBean {
	@Autowired
	@Qualifier("op1")
	Operand operand1;
	@Autowired
	@Qualifier("op2")
	Operand operand2;
	
	
	
	public PlusOp(Operand operand1, Operand operand2) {
		super();
		this.operand1 = operand1;
		this.operand2 = operand2;
	}



	@Override
	public int doOperate() {
		return Integer.parseInt(operand1.toString())+Integer.parseInt(operand2.toString());
	
	}

}










