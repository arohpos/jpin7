package main.calc;

/**
 * 定数クラス
 * 値を式としてみるためのクラス
 */
public class Constant implements Expression{
	private int num;
	
	public Constant(int num) {
		super();
		this.num = num;
	}
	
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
		return false;
	}
	@Override
	public int evaluate() {
		return num;
	}

}
