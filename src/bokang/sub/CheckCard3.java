package bokang.sub;

/*
체크카드 클래스 Ver.03
	: initMembers 초기화 메소드는 삭제처리 
	
	1.충전은 10000원 단위로만 가능하다.
	만약 5000원을 충전하면 충전불능으로 처리한다.
	
	2.잔고가 부족하면 결제불능으로 처리해야 한다.
	
	3.카드번호 생성시 0으로 시작할수 없고 전체자리수는 16자리여야
	한다.-보류
	
	4.생성자 오버로딩 처리
		new CheckCard3(카드번호, 소유자, 잔고, 포인트);
		new CheckCard3(카드번호, 소유자, 잔고); => 포인트 0으로 초기화
		new CheckCard3(카드번호, 소유자); => 잔고, 포인트 0으로 초기화
	
	5.포인트 적립율 변경
		10만원 이하결재 : 0.1%적립
		10만원 초과결재 : 0.3%적립
 */

public class CheckCard3 {
	////멤버변수 해당클래스의 속성값들 표현
	//패키지가 메인함수와 다르므로 public 선언
	private long cardNumber;
	private String owner;
	private int balance;
	private int point;
		
	/*
	 멤버변수가 private으로 선언되면 클래스 내부에서만 접근이 가능하다.
	 외부에서 접근하려면 getter/setter 가 필수적으로 생성되어야 한다. 
	 
	 ※getter-setter: private한 멤버변수에 접근할 수 있도록 하기 위함이며, 무조건 public
	 */
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	/*
	 생성자메소드와 멤버메소드의 유일한 차이점은 생성자는 반환값이 없고, 멤버메소드는 반환값이 있다는 것이다.
	 반환값이 없더라도 메소드의 특징을 모두 가지고 있으므로 메소드.
	 따라서 멤버메소드를 정의할 때는 반드시 void 혹은 반환타입을 명시하여야 한다.
	*/
	//생성자 메소드, 대부분 public(싱글턴패턴 등의 디자인패턴의 경우에만 private을 사용하기도 한다.), 
	//기본생성자
	public CheckCard3() {}
	//인자생성자
	public CheckCard3(long cardNumber, String owner, int balance, int point) {
		
		//카드번호의 자리수가 조건에 맞지 않는 경우. 생성 불능 처리
		if(cardNumberRange(cardNumber)==false) {
			System.out.println("카드생성불능: 카드번호는 0으로 시작할 수 없고 전체자리수는 16자리여야 합니다.");
			return;
		}
		else {
			this.cardNumber = cardNumber;
			this.owner = owner;
			this.balance = balance;
			this.point = point;
		}		
	}
	public CheckCard3(long cardNumber, String owner, int balance) {
			
			//카드번호의 자리수가 조건에 맞지 않는 경우. 생성 불능 처리
			if(cardNumberRange(cardNumber)==false) {
				System.out.println("카드생성불능: 카드번호는 0으로 시작할 수 없고 전체자리수는 16자리여야 합니다.");
				return;
			}
			else {
				this.cardNumber = cardNumber;
				this.owner = owner;
				this.balance = balance;
				this.point = 0;
			}		
		}
	public CheckCard3(long cardNumber, String owner) {
		
		//카드번호의 자리수가 조건에 맞지 않는 경우. 생성 불능 처리
		if(cardNumberRange(cardNumber)==false) {
			System.out.println("카드생성불능: 카드번호는 0으로 시작할 수 없고 전체자리수는 16자리여야 합니다.");
			return;
		}
		else {
			this.cardNumber = cardNumber;
			this.owner = owner;
			this.balance = 0;
			this.point = 0;
		}		
	}
	////멤버메소드 동작 표현
	//충전
	public void charge(int amount) {
		//충전할 금액을 잔고에 더한다.		
		if(amount%10000!=0) {
			System.out.println("충전불능: 충전 금액은 1만원 단위로 가능합니다.");
			return;
		}		
		else {
			this.balance+=amount;
		}
	}
	
	//결제
	public void payment(int amount) {		
		//결제할 금액만큼 잔고에서 차감된다.		
		if(balance<amount) {
			System.out.println("결제불능: 잔고부족");
			return;
		}
		else {
			this.balance-=amount;
			//카드를 사용할 때 적립금이 발생하도록 호출한다
			savingPoint(amount);
		}
	}
	
	//카드번호가 정상인지 확인하기 위한 메소드
	public boolean cardNumberRange(long cn) {
		if(cn>=1000_0000_0000_0000L
				&& cn<=9999_9999_9999_9999L) {
			return true;
		}
		else
			return false;
	}
	
	//적립
	public void savingPoint(int amount) {	
		double plusPoint = 0;
		if(amount>100000) {
			plusPoint=(amount*0.3);
		}
		else {
			plusPoint=(amount*0.1);			
		}
		this.point += plusPoint;
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
