package main.shopping.service;

import java.util.Iterator;

import main.shopping.entity.ProductsPair;

public class ProductsPairList implements Iterable<ProductsPair> {
	
	private final ProductsPair[] productsPairs;
	
	public ProductsPairList(int maxSize) {
		this.productsPairs = new ProductsPair[maxSize];
	}
	
	public int size() {
		return this.productsPairs.length;
	}
	
	public ProductsPair productsPairAt(int index) {
		return this.productsPairs[index];
	}
	
	public ProductsPairList add(ProductsPair productsPair) {
		ProductsPairList productPairList = new ProductsPairList(this.productsPairs.length + 1);
		for(int i = 0; i < productPairList.productsPairs.length; i++) {
			if(i == productPairList.productsPairs.length - 1) {			
				productPairList.productsPairs[i] = productsPair;
			}else {
				productPairList.productsPairs[i] = this.productsPairs[i];				
			}
		}
		return productPairList;
	}

	@Override
	public Iterator<ProductsPair> iterator() {
		return new ProductsPairListIterator(this);
	}
}
