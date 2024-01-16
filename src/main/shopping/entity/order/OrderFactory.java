package main.shopping.entity.order;

import main.shopping.entity.Item;
import main.shopping.entity.OrderLimit;
import main.shopping.valueObject.Quantity;

/**
 * 注文上限
 */
public class OrderFactory {
	// Orderを作成する
	public static Order create(Item item, Quantity quantity) {
		OrderLimit limitter = OrderLimit.buildLimitter();
		//TODO:Orderコンストラクタがここからしか呼ばれないようにpackage化する
		Order order = new Order(item, quantity);
		//注文数が上限数を超えたら例外を投げる
		limitter.check(order);
		return order;
	}
}
