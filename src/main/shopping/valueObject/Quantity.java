package main.shopping.valueObject;

/**
 * 数量に関する値オブジェクト
 */
public class Quantity {
	private final int quantity;
	
	//1から99の数量を扱う
	public Quantity(int quantity) {
		super();
		if(quantity <= 0 || 100 <= quantity){
			throw new IllegalArgumentException();
		}
		this.quantity = quantity;
	}
	//TODO:is this wrong?
	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "個数: " + this.quantity;
	}
	
	public boolean isLessThan(Quantity targetQuantity) {
		if(this.quantity < targetQuantity.quantity) {
			return true;
		} else {
			return false;
		}
	}
	
	public Quantity add(Quantity targetQuantity) {
		return new Quantity(this.quantity + targetQuantity.quantity);
	}
	
}
