package bokang.sub;

/*
체크카드 클래스 Ver.02

버전02에서 추가부분
	1. 멤버변수 초기화 메소드 정의 
		=> 메소드명 : initMembers()
	2. 기본생성자, 인자생성자 정의
	3. 멤버변수 정보은닉
	4. getter/setter 메소드 추가
*/

public class CheckCard2 {
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
	
	//멤버(일반)메소드는 반환타입이 있어야 해서 void를 붙인다.
	public void initMembers(long cardNumber, String owner, int balance, int point) {
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	
	/*
	 생성자메소드와 멤버메소드의 유일한 차이점은 생성자는 반환값이 없고, 멤버메소드는 반환값이 있다는 것이다.
	 반환값이 없더라도 메소드의 특징을 모두 가지고 있으므로 메소드.
	 따라서 멤버메소드를 정의할 때는 반드시 void 혹은 반환타입을 명시하여야 한다.
	*/
	//생성자 메소드, 대부분 public(싱글턴패턴 등의 디자인패턴의 경우에만 private을 사용하기도 한다.), 
	//기본생성자
	public CheckCard2() {}
	//인자생성자
	public CheckCard2(long cardNumber, String owner, int balance, int point) {
		super();
		this.cardNumber = cardNumber;
		this.owner = owner;
		this.balance = balance;
		this.point = point;
	}
	
	
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
