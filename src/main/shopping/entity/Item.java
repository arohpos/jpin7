package main.shopping.entity;

import main.shopping.valueObject.Name;
import main.shopping.valueObject.Price;

/**
 *　商品名と価格からなる商品エンティティ
 */
public abstract class Item {
	private final Name name;
	private final Price price;
	
	public Item(Name name, Price price) {
		if(name == null || name.equals("")) {
			throw new IllegalArgumentException();
		}
		if(price == null){
			throw new IllegalArgumentException();			
		}
		this.name = name;
		this.price = price;
	}
	//TODO:is this wrong?
	public int getPrice() {
		return this.price.getAmount();
	}
	@Override
		public String toString() {
			return "商品名: " + this.name.toString() + " 単価: " + this.price.toString(); 
		}
	@Override
	public boolean equals(Object targetObject) {
		if(targetObject instanceof Item) {
			Item targetItem = (Item)targetObject;
			return this.name.equals(targetItem.name);
		}
		return false;
	}
		

}
