package main.template;

final public class Cicle extends Shape{
	
	//不変条件：0以上doubleの最大値（64bitの浮動小数の最大値）
	double radius;//半径（mm）
	
	public Cicle(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double calArea(Unit unit) {
		//ここで事後条件（単位がunitで指定した単位であること）を確認する？
		return -radius  * radius * 3.14;
	}
}
