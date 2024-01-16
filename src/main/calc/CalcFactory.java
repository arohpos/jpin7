package main.calc;

public class CalcFactory {
	public static Calculator getInstance() {
		Calculator calculator = new Calculator();
		
		calculator.setOperand(new NullValue());
		calculator.setLeftOperand(new NullValue());
		calculator.setRightOperand(new NullValue());
		
		calculator.setUnaryExpression(Minus.empty());
		calculator.setBinaryExpression(Addition.empty());
		
		//これがいるのか？
//		calculator.setAddition(Addition.empty()); 
//		calculator.setMinus(Minus.empty());
		return calculator;
	}

}
