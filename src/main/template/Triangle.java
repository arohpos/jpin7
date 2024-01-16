package main.template;

final public class Triangle extends Shape {
	
	double height;		//高さ（mm）
	double width;		//幅（mm）
	
	public Triangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	@Override
	public double calArea(Unit unit) {
		return height * width / 2;
	}
}
