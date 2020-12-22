package ex08class;

class FruitSeller{ //과일판매자를 추상화한 클래스
	int numOfApple = 100; //판매자의 사과 보유 갯수
	int myMoney = 0; //판매 수익
	final int APPLE_PRICE=1000; //사과의 단가, 
	//클래스 내 멤버 상수는 선언과 동시에(처음부터) 초기화를 '필수적으로' 해아한다. 
	//한번 설정시 변경 불가한 성격때문
	//초기화를 별도 진행시 에러가 발생된다 
	//final int APPLE_PRICE 이렇게만 써두면 안됨 (=초기화 할 값) 을 붙여야 함
	
	
	//판매자가 사과를 판매하는 행위를 표현한 멤버메소드
	/*
	
	 1. 구매자로부터 금액을 전달받는다(매개변수)
	 2. 금액에 해당하는 판매될 사과의 갯수를 구한다
	 3. 보유한 재고에서 갯수만큼 차감한다
	 4. 판매수익이 증가한다
	 5. 구매자에게 판매한 사과의 갯수를 반환한다
	  
	 */
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

//구매자를 표현한 클래스
class FruitBuyer{
	
	int myMoney=5000; //보유금액 잔고
	int numOfApple=0; //구매한 사과의 갯수
	
	//구매자가 판매자에게 사과를 구매하는 행위를 표현한 멤버메소드
	/*
	 
	 1. 판매자에게 금액을 지불한다
	 2. 판매자가 금액에 해당하는 사과의 갯수를 반환해준다
	 	반환한 갯수만큼 보유한 사과의 갯수가 증가한다.
	 3. 판매자에게 지불한 금액만큼 차감된다
	 
	 */
	public void buyApple(FruitSeller seller, int money) {
		numOfApple +=seller.saleApple(money);
		myMoney -=money;
		
	}
	
	//구매자의 현재 상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재 잔액: "+myMoney);
		System.out.println("[구매자]사과 갯수: "+numOfApple);
	}
}

public class E06FruitSalesMain1 {

	public static void main(String[] args) {

		FruitSeller seller = new FruitSeller(); //판매자 객체
		FruitBuyer buyer = new FruitBuyer(); //구매자 객체
		
		System.out.println("구매행위가 일어나기 전의 상태");
		seller.showSaleResult();
		buyer.showBuyResult();
	
		// 구매자가 판매자에게 5000원을 지불하고 사과를 구매한 행위를 코드로 표현
		
		buyer.buyApple(seller, 5000);
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller.showSaleResult();
		buyer.showBuyResult();
	}

}
