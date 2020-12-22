package bokang.sub;

/*
체크카드 클래스 Ver.01

시나리오] 체크카드를 클래스로 표현해보자.
	멤버변수 : 카드번호, 소유자, 잔액, 포인트
	멤버메소드 : 충전(입금), 결제, 적립, 현재상태출력
	적립율 : 사용금액의 0.1%	
	
	class의 요소: 멤버변수, 멤버메소드, 생성자메소드
*/

public class CheckCard1 {
	////멤버변수 해당클래스의 속성값들 표현
	//패키지가 메인함수와 다르므로 public 선언
	public long cardNumber;
	public String owner;
	public int balance;
	public int point;
		
	////멤버메소드 동작 표현
	//충전
	public void charge(int amount) {
		//충전할 금액을 잔고에 더한다.
		this.balance+=amount;		
	}
	//결제
	public void payment(int amount) {
		//결제할 금액만큼 잔고에서 차감된다.
		this.balance-=amount;
		//카드를 사용할 때 적립금이 발생하도록 호출한다
		savingPoint(amount);
	}
	//적립
	public void savingPoint(int amount) {		
		//this.point+=(amount*0.1);
		double plusPoint=amount*0.1;
		this.point += plusPoint; //큰게 작은타입으로 들어가는데 에러가 안나는이유? 복합대입연산자 때문. 자동으로 형변환 일어남.
	}
	//현재상태 출력(멤버변수)
	public void showState() {
		System.out.println("==================================================");
		System.out.println("카드번호: "+cardNumber);
		System.out.println("소유자: "+owner);
		System.out.println("잔고: "+balance);
		System.out.println("포인트: "+point);
		System.out.println("==================================================");
	}
}
