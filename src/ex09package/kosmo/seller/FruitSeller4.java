package ex09package.kosmo.seller;

public class FruitSeller4{ //과일판매자를 추상화한 클래스
	int numOfApple = 100; //판매자의 사과 보유 갯수
	int myMoney = 0; //판매 수익
	final int APPLE_PRICE; //사과의 단가 //초기화 하지 않은 상수
	
	public FruitSeller4(int money, int appleNum, int price) {
		myMoney =money;
		numOfApple=appleNum;
		APPLE_PRICE=price;
	}
	
	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple-=num;
		myMoney+=money;
		return num;		
	}
	
	//판매자의 현재 상태를 출력하는 멤버메소드
	public void showSaleResult() {
		System.out.println("[판매자]남은 사과 갯수: "+numOfApple);
		System.out.println("[판매자]판매수익: "+myMoney);
	}
	
}
