package main.calc;

/**
 * 符号反転クラス
 */
public class Minus extends UnaryOperation{
	
	private Expression operand;
	
	public Minus(Expression opperand) {
		super();
		this.operand = opperand;
	}
	
	public static Expression empty() {
		return new Minus(new NullValue());
	}
	
	@Override
	public void setOperand(Expression operand) {
		this.operand = operand;
	}
	
	@Override
	public int evaluate() {
		return -operand.evaluate();
	}
}
