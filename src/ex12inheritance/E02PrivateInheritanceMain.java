package ex12inheritance;

class Account { //부모클래스
	
	/*
	 
	 멤버변수가 상속관계에 있다 하더라도 private으로 선언되면 클래스 내부에서만 접근 가능하다
	 즉 상속받은 하위클래스에서는 직접 접근이 불가능하다
	  
	 */
	private int money;//잔고 멤버변수
	public Account(int init) { //생성자는 늘 public(디자인패턴 제외), 자료형x
		money=init;
	}
	
	//입금처리: protected로 선언되었으므로 상속관계에서 접근 가능
	protected void depositMoney(int _money) {
		if(_money<0) {
			System.out.println("마이너스 금액은 입금처리 불가합니다.");
			return;
		}
		money += _money;
	}
	
	//private 멤버를 외부클래스로 반환할 때 사용한다
	protected int getAccMoney() {
		return money;
	}
}

class SavingAccount extends Account{ //자식클래스
	
	/*
	 
	  인자생성자에서 부모의 생성자 메소드를 호출하기 위해 super()를 사용한다.
	 이때 인자가 하나인 생성자를 호출하게 된다.
	  
	 */
	public SavingAccount(int initVal) {
		super(initVal);
	}
	
	/*
	 
	 부모클래스에 protected로 선언된 멤버메소드를 각각 호출한다
	 private멤버변수인 money는 직접 접근할 수 없으므로
	 접근 가능한 메소드를 통해 간접적으로 접근한다.
	  
	 */
	public void saveMoney(int money) {
		depositMoney(money);
	}
	public void showAccountMoney() {
		System.out.println("지금까지의 누적금액: "+getAccMoney());
		// System.out.println("지금까지의 누적금액: "+money()); 접근불가(private멤버)
	}
}

public class E02PrivateInheritanceMain { //다른 클래스에서 접근시도

	public static void main(String[] args) {
		
		//private멤버이므로 상속받은 하위클래스의 참조변수를 통해서는 접근이 불가능
		//부모의 멤버메소드를 통해 간접적으로 접근한다
		SavingAccount sa=new SavingAccount(10000);
		
		//sa.money=100000; 접근불가
		
		sa.saveMoney(5000);
		sa.showAccountMoney();
		
		sa.saveMoney(-1000); //입금불가 처리(코드에러 x 메시지가 뜨도록 처리)
		sa.showAccountMoney();
		
		/*
		 
		 부모객체의 참조변수를 통해서도 private 멤버는 접근이 불가능하다
		 현재 접근하고 있는 위치가 다른 클래스이기 때문
		  
		 */
		
		Account account = new Account(1000);
		//account.money=1000; 접근불가
	}

}
