package main.strategy;

public class Main {

	public static void main(String[] args) {

		int num1 = 5;
		int num2 = 2;
		int result = 0;//仮の初期値
		
		Caliculator caliculater = new Caliculator(num1, num2, new Minus());
		result = caliculater.caliculate();
		System.out.println(result);

	}
}
