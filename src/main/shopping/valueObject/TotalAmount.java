package main.shopping.valueObject;

/**
 * 金額合計に関する値オブジェクト
 */

//0以上の合計金額を扱う
public class TotalAmount {
	private final int amount;
	
	public TotalAmount(int amount) {
		if(amount < 0) {
			throw new IllegalArgumentException();
		}
		this.amount = amount;
	}
	
	public TotalAmount add(TotalAmount target) {
		return new TotalAmount(target.amount + this.amount);
	}
	
	@Override
	public String toString() {
		return "合計金額: " + this.amount + "円";
	}
}
