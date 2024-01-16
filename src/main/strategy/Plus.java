package main.strategy;

public class Plus implements Operator{
	
//	@Override
//	public int exec(int num1, int num2) {
//		return num1 + num2;
//	}

	@Override
	public int exec(int... nums) {
		int result = 0;
		for(int num : nums) {
			result += num;
		}
		return result;
	}
}
