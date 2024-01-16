package main.shopping.entity.order;

import main.shopping.entity.Item;
import main.shopping.valueObject.Quantity;
import main.shopping.valueObject.TotalAmount;

/**
 * 商品と数量からなる注文エンティティ
 */
public class Order {
	private final Item item;
	private final Quantity quantity;

	// TODO：OrderFactoryとOrderクラスを同じpackageにいれて、
	// Orderのコンストラクタをprotectedにすることで、
	// OrderFactoryからしか生成できないようにするべきでは。
	// cf)Factoryパターン
	public Order(Item item, Quantity quantity) {
		if (item == null || quantity == null) {
			throw new IllegalArgumentException();
		}
		this.item = item;
		this.quantity = quantity;
	}

	// 1つの注文の合計金額を計算する
	// TODO:TotalAmountクラスにあってもいいのでは。
	public TotalAmount calcTotal() {
		return new TotalAmount(this.item.getPrice() * this.quantity.getQuantity());
	}

	@Override
	public String toString() {
		return "<注文> " + this.item + " " + this.quantity;
	}

	// 別Orderが同じ商品に関する注文であることを確認する
	public boolean hasSameItem(Order targetOrder) {
		return this.item.equals(targetOrder.item);
	}

	//注文数を比較する
	public boolean isLessThan(Order targetOrder) {
		if (this.hasSameItem(targetOrder)) {
			return this.quantity.isLessThan(targetOrder.quantity);
		}else {
			throw new IllegalArgumentException();
		}
	}

	//既存注文と同一商品の場合、注文数を付加する
	public Order append(Order targetOrder) {
		if (this.hasSameItem(targetOrder)) {
			return OrderFactory.create(this.item, this.quantity.add(targetOrder.quantity));
		} else {
			throw new IllegalArgumentException();
		}

	}

}
