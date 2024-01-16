package main.shopping.entity;

import main.shopping.valueObject.Name;
import main.shopping.valueObject.Price;

/**
 * 単品商品
 */
public class Product extends Item{
	public Product(Name name, Price price) {
		super(name, price);
	}
}

