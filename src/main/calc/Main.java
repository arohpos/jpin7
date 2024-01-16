package main.calc;

public class Main {
	public static void main(String[] args) {
		Expression a = new Constant(3);
		Expression b = new Constant(2);
		Calculator calculator = CalcFactory.getInstance();
		calculator.setLeftOperand(a);
		calculator.setOperator(Operator.ADDITION);
		calculator.setRightOperand(b);
		System.out.println(calculator.getResult());
		
		Calculator calculator2 = CalcFactory.getInstance();
		calculator2.setOperand(a);
		calculator.setOperator(Operator.MINUS);
		System.out.println(calculator.getResult());
		
	}
}
