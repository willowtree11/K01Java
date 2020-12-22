package ex12inheritance;
/*
이 문제만 이해해도 90% 이해도
 문제5) QuBuyHamburger.java
햄버거를 추상화한 클래스와 기본가격, 세트가격을 추상화한 클래스를 정의하여 햄버거를 주문시 기본가격 혹은 세트가격으로 출력할수 있도록 프로그램을 구현하시오. 
조건은 다음과 같다. 
햄버거
멤버변수 : 버거명, 가격, 패티, 소스, 야채
인자생성자 
멤버메소드 : 가격반환(getter), 햄버거정보출력
햄버거 기본가격 : 햄버거 + 음료 + 프렌치프라이의 합계
멤버변수 : 햄버거종류(객체), 음료가격(1000원으로 고정), 프렌치프라이가격(1500원으로 고정)
인자생성자
멤버메소드 : 기본가격계산, 결제금액출력
세트가격 : 기본가격클래스를 상속받음. 기본가격에서 500원 할인된 금액으로 계산
멤버변수 : 없음
인자생성자
멤버메소드 : 세트가격계산(Overriding), 결제금액출력(Overriding)

치즈버거
가격:2000
식재료:쇠고기패티, 케챱, 피클
결제금액 : 4500
================================
치킨버거
가격:3000
식재료:닭고기패티, 마요네즈, 양상치
세트결제금액 : 5000
================================

 
 */

//햄버거를 추상화
class Burger { 
	//멤버변수
	/* 버거명, 가격, 패티, 소스, 야체을 표현 */
	private String burgerName;
	private int price;
	private String patty;
	private String sauce;
	private String vegetable;
	//인자생성자
	public Burger(String burgerName, int price, String patty, String sauce, String vegetable) {
		super();
		this.burgerName = burgerName;
		this.price = price;
		this.patty = patty;
		this.sauce = sauce;
		this.vegetable = vegetable;
	}
	public String getBurgerName() {
		return burgerName;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPatty() {
		return patty;
	}
	public void setPatty(String patty) {
		this.patty = patty;
	}
	public String getSauce() {
		return sauce;
	}
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	public String getvegetable() {
		return vegetable;
	}
	public void setvegetable(String vegetable) {
		this.vegetable = vegetable;
	}
	
	//getter : price만 필요
	
	//햄버거 정보 출력
	public void showBurger() {
		System.out.println(burgerName);
		System.out.println("가격: "+price);
		System.out.printf("식재료:%s, %s, %s\n", patty, sauce, vegetable);
	}
	
	/* 버거명, 가격, 식재료 출력*/
}
//햄버거의 기본가격 추상화 
class HamburgerPrice {
	//멤버변수
	/* 햄버거종류, 음료, 프렌치프라이 */
	Burger burger;
	final int COKE = 1000;
	final int POTATO = 1500;

	//인자생성자: 상수는 이미 초기화 되어 있으므로 햄버거 객체만 초기화한다.
	public HamburgerPrice(Burger burger) {
		this.burger = burger;
	}
	//기본가격계산: 햄버거+콜라+프렌치프라이 가격의 합
	public int price() {
		int total = burger.getPrice() + COKE + POTATO; //burger.getPrice() 햄버거 price는 프라이빗이라 그냥 가져올 수 없어서 getter 통해 가져와야 함
		return total;		
	}
	
	//햄버거와 결제금액 출력
	public void showPrice() {
		burger.showBurger(); //디폴트(default) 접근지정자로 설정
		System.out.println("결제금액: "+price());
		System.out.println("========================================");
	}
}
//세트가격을 추상화(기본가격을 상속)
class SetPrice extends HamburgerPrice {	
	//인자생성자
	public SetPrice(Burger burger) {
		//부모클래스에 정의된 인자생성자 호출
		super(burger);
	}
	
	//세트가격계산(오버라이딩): 500원 할인된 가격으로 계산함 -> 부모쪽에서는 기본가격(햄+콜+감), 자식쪽에서 500원 할인
	@Override
	public int price() {
		return super.price()-500;
	}
	
	//햄버거와 세트결제금액 출력(오버라이딩)	
	@Override
	public void showPrice() {
		//디폴트 접근지정자는 동일 패키지에서는 접근을 허용
		burger.showBurger();
		System.out.println("세트결제금액: "+price());
		System.out.println("==============================");
	}
}

public class QuBuyHamburger {

	public static void main(String[] args) {
		
		//치즈버거 객체 생성
		Burger burger1 = new Burger("치즈버거", 2000, "쇠고기패티", "케챱", "피클");
		//치킨버거 객체 생성
		Burger burger2 = new Burger("치킨버거", 3000, "닭고기패티", "마요네즈", "양상치");
		
		//치즈버거를 기본가격으로 구매
		HamburgerPrice price1 = new HamburgerPrice(burger1); 
		price1.showPrice();	// 4500원	
		
		//치킨버거를 세트가격으로 구매
		HamburgerPrice price2 = new SetPrice(burger2); 
		price2.showPrice();	// 5000원
	}
}