package main.calc;
public abstract class BinaryOperation implements Expression{

	public abstract void setLeft(Expression leftOperand); 
	public abstract void setRight(Expression rightOperand); 
	
	@Override
	public boolean isNull() {
		return false;
	}
	@Override
	public boolean isUnaryOperation() {
		return false;
	}
	@Override
	public boolean isBinaryOperation() {
		return true;
	}
}
