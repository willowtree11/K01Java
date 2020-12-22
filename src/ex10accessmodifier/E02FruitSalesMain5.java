package ex10accessmodifier;
//생성자에서는 상수 초기화 가능
class FruitSeller5{ //과일판매자를 추상화한 클래스
	int numOfApple = 100; //판매자의 사과 보유 갯수
	int myMoney = 0; //판매 수익
	final int APPLE_PRICE; //사과의 단가 //초기화 하지 않은 상수
	
	//상수는 값의 변경이 불가능하고, 단 한번만 초기화되기 때문에
	//일반적인 멤버메소드에서는 초기화 할 수 없다
	//하지만 생성자 메소드에서는 초기화가 가능하다
	//1. 마음대로 호출할 수 없고, 2. 객체생성시 단 한번만 호출되는 특성이 동일하고,
	//3. 한번이상 초기화되지 않음이 보장되기 때문.
	//생성자/ 반환값 x
	//생성자는 객체를 생성할 때 단 한번 호출되므로 이때 멤버상수를 한번 초기화 가능한 것.
	public FruitSeller5(int money, int appleNum, int price) {
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

//구매자를 표현한 클래스
class FruitBuyer5{
	
	int myMoney;
	int numOfApple;		
	
	public FruitBuyer5(int _myMoney, int _numOfApple) {
		myMoney=_myMoney;
		numOfApple=_numOfApple;				
	}
	
	//구매자가 판매자에게 사과를 구매하는 행위를 표현한 멤버메소드
	public void buyApple(FruitSeller5 seller, int money) {
		numOfApple +=seller.saleApple(money);
		myMoney -=money;
		
	}
	
	//구매자의 현재 상태 출력
	public void showBuyResult() {
		System.out.println("[구매자]현재 잔액: "+myMoney);
		System.out.println("[구매자]사과 갯수: "+numOfApple);
	}
}

public class E02FruitSalesMain5 {

	public static void main(String[] args) {

		
		//2번 파일에서 2줄이던것을 1줄로 변경 가능(생성자)
		FruitSeller5 seller1 = new FruitSeller5(0, 100, 1000);
		
		FruitSeller5 seller2 = new FruitSeller5(0, 80, 500);
		
		FruitBuyer5 buyer = new FruitBuyer5(10000, 0);
		
		System.out.println("구매행위가 일어나기 전의 상태\n");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		buyer.buyApple(seller1,  5000);
		buyer.buyApple(seller2,  5000);
	
		System.out.println("\n구매행위가 일어난 후의 상태\n");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
		//이하 코드는 문법적으로 문제가 없으나 지불금액과 구매한 사과의 관계가 맞지 않는다(논리적 오류가 있음)
		//즉, 코드(메소드)로 구현한 규칙이 완전히 무너지게 된다.
		//객체지향 프로그래밍에서는 이런 오류를 막기 위해 멤버변수에 대한 "정보은닉"을 하도록 규정하고 있다.
		
		seller1.myMoney += 1000; //판매자1에게 1000원을 지불하고
		seller1.numOfApple -= 50; //사과 50개를 구매했다
		buyer.numOfApple +=50;
		
		seller2.myMoney += 1000; //판매자2에게 1000원을 지불하고
		seller2.numOfApple -= 70; //사과 70개를 구매했다
		buyer.numOfApple +=70; //하지만 구매자의 보유금액은 차감되지 않았다.
		
		System.out.println("구매행위가 일어난 후의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
	}

}
