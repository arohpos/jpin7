package main.calc;

/**
 * 式インターフェース
 */
public interface Expression {
	boolean isNull();
	boolean isUnaryOperation();
	boolean isBinaryOperation();
	int evaluate();
}
