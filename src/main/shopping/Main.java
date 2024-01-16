package main.shopping;

import main.shopping.entity.Item;
import main.shopping.entity.Product;
import main.shopping.entity.ShoppingCart;
import main.shopping.entity.order.Order;
import main.shopping.entity.order.OrderFactory;
import main.shopping.valueObject.Name;
import main.shopping.valueObject.Price;
import main.shopping.valueObject.Quantity;

public class Main {
	public static void main(String[] args) {
		
		//TODO:ItemFactory。Mainから商品生成ができるようにする。
		//TODO:Itemの登録先みたいなものは不要か？これがRepositoryか？
		//TODO:OrderLimitFactoryの作成。Mainから数量制限ができるようにする。
		
		//Itemを生成する。
		Item apple = new Product(new Name("apple"), new Price(100));
		Item banana = new Product(new Name("banana"), new Price(80));
		Item chocolate = new Product(new Name("chocolate"), new Price(150));
		
		//Orderを生成する
		Order order1 = OrderFactory.create(apple, new Quantity(5));
		Order order2 = OrderFactory.create(banana, new Quantity(8));
		Order order3 = OrderFactory.create(chocolate, new Quantity(2));
		
		//Orderレベルでの合計値を出力する
		System.out.println("---Order calc test---");
		System.out.println(order1);
		System.out.println(order1.calcTotal());		
		System.out.println(order2);
		System.out.println(order2.calcTotal());
		System.out.println(order3);
		System.out.println(order3.calcTotal());
		
		//ショッピングカート（複数注文）レベルでの合計値
		System.out.println("---shoppingcart add test---");
		ShoppingCart shoppingCart = new ShoppingCart();
		System.out.println("--add apple");		
		shoppingCart.recieve(order1);
		System.out.println("--add banana");
		shoppingCart.recieve(order2);
		System.out.println("--add choco1");
		shoppingCart.recieve(order3);
		System.out.println("---shoppingcart calc test---");
		System.out.println(shoppingCart);
		System.out.println(shoppingCart.calcTotal());
		
	
		//規定の上限値を超えたOrderをする場合Exceptionがでる
		Order order4 = OrderFactory.create(apple, new Quantity(5));//10
		Order order5 = OrderFactory.create(banana, new Quantity(5));//15
		Order order6 = OrderFactory.create(chocolate, new Quantity(5));//5
		
		//セット商品を生成
		//セット商品に該当するかチェック
			//ProductPairとpaircheckerで実装しようとしている。どこでnextを作るべきか。これがあればチェックし易い。
			//リポジトリみたいなものがあれば、取得して、sortして、順番に格納するIteratorをつくって上げればいい。
			//普通に本棚クラスみたいなものを作ってあげるのがいい気がする。
		//セット商品を黒伝票として追加
		//赤伝票として単品2つを削除
		
		
	}
}
