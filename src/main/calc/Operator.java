package main.calc;

public enum Operator implements Expression{
	
	ADDITION(OperatorType.BINARY),
	MINUS(OperatorType.UNARY),
	SQRT(OperatorType.UNARY);
	
	private OperatorType type;
	
	private Operator(OperatorType type) {
		this.type = type;
	}
	
	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public int evaluate() {
		return 0;
	}

	@Override
	public boolean isUnaryOperation() {
		return type == OperatorType.UNARY;
	}

	@Override
	public boolean isBinaryOperation() {
		return type == OperatorType.BINARY;
	}
}
