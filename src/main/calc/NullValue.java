package main.calc;

/**
 * nullを直接扱わないようにするためのクラス
 * ポリモーフィズムの中でExpression型の実装がnullの場合、
 * メソッドを使うとNullPointExceptionになるため、nullの場合の実装を事前に用意する
 * 参考：nullObjectパターン
 */
public class NullValue implements Expression{
	@Override
	public boolean isNull() {
		return true;
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
		throw new RuntimeException();
	}
}
