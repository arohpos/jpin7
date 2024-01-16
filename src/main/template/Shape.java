package main.template;

public abstract class Shape {
	protected String fileName;
		
	public final void open() {
		System.out.println("ファイルをオープンしました");
	}
	
	//返してほしい単位を引数で渡す
	//事前条件：このメソッドを使うときは、Unitを引数で渡すこと
	//事後条件：このメソッドを実装するときは、0以上の数を返すこと
	//→これの戻り値を値オブジェクトにすれば、エラーが返せそう。
	public abstract double calArea(Unit unit);

	//使う側
	public final void execute(Unit unit) {
		this.open();
		
		//事前条件の確認：
		//事前条件に外れない単位を指定する
		//Enumをつかっていることで、事前条件が満たされている。
		//JavaDocとかの書き方調べる
		System.out.println("面積は" + calArea(unit));
		this.close();
	}
	
	public final void close() {
		System.out.println("クローズしました");
	}
}
