package main.strategy;

public class Minus implements Operator{
//	@Override
//	public int exec(int num1, int num2) {
//		return num1 - num2;
//	}
	
	@Override
	public int exec(int... nums) {
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			result -= nums[i];
		}
		return result;
	}
}
