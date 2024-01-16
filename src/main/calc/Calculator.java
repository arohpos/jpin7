package main.calc;

/**
 * 計算結果と演算子をもとに結果を返す
 */
public class Calculator {
	private Expression operand;//単項演算のオペランド
	private Expression leftOperand;//2項演算の左オペランド
	private Expression rightOperand;//2項演算の左オペランド
	private Expression operator;//演算子
	
	private Expression unaryExpression;//単項演算式
	private Expression binaryExpression;//2項演算式
	
//	private Expression minus;//プラマイのいれかえ。これをunaryExpressionとかにしたい。
//	private Expression addition;//足し算。これをbinaryExpressionとかにしたい。

	
//	public void setAddition(Expression addition) {
//		this.addition = addition;
//	}
//	public void setMinus(Expression minus) {
//		this.minus = minus;
//	}
	
	public void setUnaryExpression(Expression unaryExpression) {
		this.unaryExpression = unaryExpression;
	}
	
	public void setBinaryExpression(Expression binaryExpression) {
		this.binaryExpression = binaryExpression;
	}
	
	public void setOperand(Expression operand) {
		this.operand = operand;
	}
	public void setLeftOperand(Expression leftOperand) {
		this.leftOperand = leftOperand;
	}
	public void setRightOperand(Expression rightOperand) {
		this.rightOperand = rightOperand;
	}
	public void setOperator(Expression operator) {
		this.operator = operator;
	}

	
	public int getResult() {
		//この中でTypeがADDだったらダウンキャストみたいな処理をしたいが、それはしたくない。
		//抽象依存の原則。使う対象は具象クラスではなく抽象クラスを使うべき。
		//具体的なクラスにダウンキャストしてしまうことは避けたい。
		
		
		//結局どこかでAdditionのインスタンスを生成する必要がある。それぞれ分岐作る必要あり。
		//単項演算が増えても2項演算が増えてもCalculator変えずに実装するには、Mainで指定してあげる必要がある。
		//いずれにしてもStrategyっぽくするならMainから生成するときにOperatorを指定してしまうのがいいはず。
		if(this.operator.isUnaryOperation()) {
			UnaryOperation op = (UnaryOperation)this.unaryExpression;
			op.setOperand(this.operand);
			return op.evaluate();
		}else if(this.operator.isBinaryOperation()) {
			BinaryOperation op = (BinaryOperation)this.binaryExpression;
			op.setLeft(this.leftOperand);
			op.setRight(this.rightOperand);
			return op.evaluate();
		}
		return 0;
	}
}
