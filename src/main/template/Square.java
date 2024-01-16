package main.template;

//不変条件：heightとwidthは正数であること
final public class Square extends Shape {
	
	double height;		//高さ（mm）
	double width;		//幅（mm）
	
	//不変条件を守るように実装する
	//事前条件；正数を渡すこと
	public Square(double height, double width) {
		//nullチェック、0以上チェックをする。0未満であったら例外を投げる
		this.height = height;
		this.width = width;
	}
	
	@Override
	public double calArea(Unit unit) {
		return height * width;
	}

}
