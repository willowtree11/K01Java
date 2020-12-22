package ex09package.kosmo.buyer;

import ex09package.kosmo.seller.FruitSeller4;

public class FruitBuyer4{
	
	int myMoney;
	int numOfApple;		
	
	public FruitBuyer4(int _myMoney, int _numOfApple) {
		myMoney=_myMoney;
		numOfApple=_numOfApple;				
	}
	
	//구매자가 판매자에게 사과를 구매하는 행위를 표현한 멤버메소드
	public void buyApple(FruitSeller4 seller, int money) {
		numOfApple +=seller.saleApple(money);
		myMoney -=money;
		
	}
	
	//구매자의 현재 상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재 잔액: "+myMoney);
		System.out.println("[구매자]사과 갯수: "+numOfApple);
	}
}