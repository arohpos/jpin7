package main.shopping.entity;

import main.shopping.valueObject.Name;
import main.shopping.valueObject.Price;

/**
 * 単一別商品の組
 */
public class ProductsPair extends Item{
	private final Product[] productSet = new Product[2];
	public ProductsPair(Name name, Price price, Product product1, Product product2) {
		super(name, price);
		//別商品出ない場合、例外を投げる
		if(product1.equals(product2)) {
			throw new IllegalArgumentException();
		}
		this.productSet[0] = product1;
		this.productSet[1] = product2;
	}

}
