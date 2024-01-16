package main.shopping.valueObject;

/**
 * 明細項目金額に関する値オブジェクト
 */
public class Price {
	private final int amount;

	//0円以上100,000円未満の金額を扱う
	public Price(int amount) {
		super();
		if(amount <0 || 100_000 < amount){
			throw new IllegalArgumentException();
	}
		this.amount = amount;
	}
	//TODO:is this wrong?
	public int getAmount() {
		return this.amount;
	}
	@Override
	public String toString() {
		return String.valueOf(this.amount) + "円";
	}

}
