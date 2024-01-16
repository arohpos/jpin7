package main.shopping.service;

import java.util.Iterator;
import java.util.NoSuchElementException;

import main.shopping.entity.ProductsPair;

public class ProductsPairListIterator implements Iterator<ProductsPair> {
	private ProductsPairList productsPairList;
	private int checkingIndex;
	
	public ProductsPairListIterator(ProductsPairList productsPairList) {
		this.productsPairList = productsPairList;
		this.checkingIndex = 0;
	}

	@Override
	public boolean hasNext() {
		if(this.checkingIndex < this.productsPairList.size()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public ProductsPair next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		ProductsPair productsPair = this.productsPairList.productsPairAt(checkingIndex);
		this.checkingIndex++;
		return productsPair;
	}

}
