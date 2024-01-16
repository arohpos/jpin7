package main.calc;

/**
 * 加算クラス
 */
public class Addition extends BinaryOperation{
	
	//二項演算子のオペランドとして式を格納できる必要がある。
	private Expression leftOperand;
	private Expression rightOperand;

	public Addition(Expression leftOperand, Expression rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}
	
	public static Expression empty() {
		return new Addition(new NullValue(), new NullValue());
	}

	@Override
	public int evaluate() {
		if(leftOperand.isNull() || rightOperand.isNull()) {
			throw new IllegalArgumentException();
		}
		return leftOperand.evaluate() + rightOperand.evaluate();
	}

	@Override
	public void setLeft(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}

	@Override
	public void setRight(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}

}
