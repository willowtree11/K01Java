package ex09package;

import ex09package.kosmo.seller.FruitSeller4;

public class FruitSalesMain4 {

	public static void main(String[] args) {

		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);		
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);
		
		ex09package.kosmo.buyer.FruitBuyer4 buyer = new ex09package.kosmo.buyer.FruitBuyer4(10000, 0);
		
		System.out.println("구매행위가 일어나기 전의 상태\n");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		buyer.buyApple(seller1,  5000);
		buyer.buyApple(seller2,  5000);
		
		System.out.println("\n=====================");
		System.out.println("\n구매행위가 일어난 후의 상태\n");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
	}

}
