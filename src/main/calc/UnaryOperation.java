package main.calc;

public abstract class UnaryOperation implements Expression{
	
	public abstract void setOperand(Expression operand);
	
	@Override
	public boolean isNull() {
		return false;
	}
	@Override
	public boolean isUnaryOperation() {
		return true;
	}
	@Override
	public boolean isBinaryOperation() {
		return false;
	}
	

}
