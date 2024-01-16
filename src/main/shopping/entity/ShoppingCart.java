package main.shopping.entity;
import java.util.ArrayList;
import java.util.List;

import main.shopping.entity.order.Order;
import main.shopping.valueObject.TotalAmount;

/**
 * 注文リストからなるショッピングカートオブジェクト
 */
public class ShoppingCart {
	private List<Order> orders;
	
	//生成時は注文が入っていない状態
	public ShoppingCart() {
		List<Order> orders = new ArrayList<>();
		this.orders = orders;
	}
	
	//注文を受け取り、カートに追加する
	public void recieve(Order targetOrder) {
		//カート内に同一商品を持つ注文が存在するか判定し、カート内indexを設定する
		boolean hasSameItemOrderFlg = false;
		int sameItemOrderIndex = 0;
		System.out.println("START: Adding is processing.");
		for(Order order : orders) {
			if(order.hasSameItem(targetOrder)) {
				hasSameItemOrderFlg = true;
				sameItemOrderIndex = this.indexOf(order);
			}
		}
		//カート内に同一商品を持つ注文が存在する場合、注文をマージする
		if(hasSameItemOrderFlg) {
			System.out.println("RESULT : new order was merged.");
			orders.set(sameItemOrderIndex, orders.get(sameItemOrderIndex).append(targetOrder));
		//そうでない場合、新規注文を追加する
		}else {
			System.out.println("RESULT : new order was added.");
			this.orders.add(targetOrder);
		}
	}
	
	//カート内の注文位置indexを探す.ただし、存在しなければ-1を返す
	private int indexOf(Order targetOrder) {
		if(!this.orders.isEmpty()) {
			for(int index = 0; index < this.orders.size(); index++) {
				if(this.orders.get(index).hasSameItem(targetOrder)) {
					return index;
				}
			}
		}
		return -1;
	}
	
	// 1つの伝票内の合計金額を計算する
	//TODO:TotalAmountクラスにあってもいいのでは。
	public TotalAmount calcTotal() {
		TotalAmount totalAmount = new TotalAmount(0);
		for(Order order : orders) {
			//注文ごとに小計を計算し、伝票合計に足す
			totalAmount = order.calcTotal().add(totalAmount);
		}
		return totalAmount;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("<<伝票>>");		
		for(Order order : this.orders) {
			sb.append("\r\n");
			sb = sb.append(order.toString());
		}
		return new String(sb);
	}
	//use remove process @ Order
	public void cancel(Order targetOrder) {
		
	}
	
	//TODO:カート内にセット商品となる商品の組み合わせが無いか確認する
//	private  boolean hasProductPair() {
//		if
//	}
	private void makePair() {
		
	}
	
}
