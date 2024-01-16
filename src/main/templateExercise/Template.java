package main.templateExercise;

abstract class Template {
	//定形処理
	public void execute() {
		System.out.println("start");
		this.perform();
		System.out.println("end");
	}
	
	//拡張点
	abstract protected void perform();
		
	
}
