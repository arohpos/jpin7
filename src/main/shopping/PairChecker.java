package main.shopping;

import main.shopping.entity.Item;
import main.shopping.entity.Product;
import main.shopping.entity.ProductsPair;
import main.shopping.valueObject.Name;
import main.shopping.valueObject.Price;

public class PairChecker {
	ProductsPair productsPair;
	PairChecker next;
	
	public PairChecker(Name name, Price price, Product product1, Product product2) {
		this.productsPair = new ProductsPair(name, price, product1, product2);
	}
	
	private PairChecker setNext(PairChecker next) {
		this.next = next;
		return next;
	}
	//注文の数量制限オブジェクトの生成
	public static PairChecker buildPairs() {
		// TODO：ここでセット情報の定義をしてしまって良いのか？
		// Pairを定義するのではなく、定義されているPairを取得するべきなのではないか。これもRepository？
		Item apple = new Product(new Name("apple"), new Price(100));
		Item banana = new Product(new Name("banana"), new Price(80));
		Item chocolate = new Product(new Name("chocolate"), new Price(150));
		//appleと一緒に頼むと３０円引き
		Item appleBananaSet = new ProductsPair(new Name("apple banana set"), new Price(150), (Product)apple, (Product)banana);
		Item appleChocolateSet = new ProductsPair(new Name("apple chocolate set"), new Price(220), (Product)apple, (Product)chocolate);

		//これを全部チェインするとpairsの戻り値がapple chocolate setになる
		//TODO:chainの1番目はnullみたいなものにするべきではないか。
		PairChecker pairs = new PairChecker(new Name("apple banana set"), new Price(150), (Product)apple, (Product)banana);
				pairs
					.setNext(new PairChecker(new Name("apple chocolate set"), new Price(220), (Product)apple, (Product)chocolate));
		return pairs;
	}
	
	public void check() {}
	

}
