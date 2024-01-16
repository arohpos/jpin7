package main.shopping.entity;

import main.shopping.LimitOverException;
import main.shopping.entity.order.Order;
import main.shopping.valueObject.Name;
import main.shopping.valueObject.Price;
import main.shopping.valueObject.Quantity;

/**
 * 注文上限エンティティ
 */
public class OrderLimit {
	private Order orderLimit;
	private OrderLimit next;

	public OrderLimit(Item item, Quantity orderableMaxQuantity) {
		this.orderLimit = new Order(item, orderableMaxQuantity);
	}

	// 引数として受け取った数量制限が、このインスタンスの次の個数制限であることを設定する
	// 戻り値として、引数で受け取った次の個数制限を返す
	private OrderLimit setNext(OrderLimit next) {
		this.next = next;
		return next;
	}

	//注文の数量制限オブジェクトの生成
	public static OrderLimit buildLimitter() {
		// TODO：ここで商品情報の定義をしてしまって良いのか？
		// Itemを定義するのではなく、定義されているItemを取得するべきなのではないか。これもRepository？
		Item apple = new Product(new Name("apple"), new Price(100));
		Item banana = new Product(new Name("banana"), new Price(80));
		Item chocolate = new Product(new Name("chocolate"), new Price(150));

		//これを全部チェインするとlimmiterの戻り値がchocolateになる
		//TODO:chainの1番目はnullみたいなものにするべきではないか。
		OrderLimit limitter = new OrderLimit(apple, new Quantity(10));
				limitter
					.setNext(new OrderLimit(banana, new Quantity(15)))
					.setNext(new OrderLimit(chocolate, new Quantity(5)));
		return limitter;
	}

	// 商品の注文数が上限を超えた場合例外を投げる
	public void check(Order targetOrder) {
		if (this.orderLimit.hasSameItem(targetOrder)) {
			if (this.orderLimit.isLessThan(targetOrder)) {
				throw new LimitOverException(); 
			}
		} else if(this.next != null){
			this.next.check(targetOrder);
		}
	}
}
