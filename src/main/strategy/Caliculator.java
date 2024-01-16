package main.strategy;

public class Caliculator {
	
	int num1;
	int num2;
	Operator operator;
	
	public Caliculator(int num1, int num2, Operator operator) {
			
		//単行演算子か２項演算子かどうかによって、引数の数をチェックする？
		
		this.num1 = num1;
		this.num2 = num2;
		this.operator = operator;
	}
	
	public int caliculate() {
		return this.operator.exec(num1, num2);
	}
	

}
