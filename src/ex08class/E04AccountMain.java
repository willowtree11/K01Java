package ex08class;
/*
 
시나리오]
은행계좌를 추상화 해보자
멤버변수: 예금주(name), 계좌번호(accountNumber), 잔고(balance)
멤버메소드: 입금하다(deposit()), 출금하다(withdraw()), 계좌잔고 출력하기(showAccount())
조건1: 입금은 무제한으로 가능
조건2: 잔고가 부족할 경우에는 출금 불능 처리

결과

기존 잔고: 1000
9000원이 입금 되었습니다.
계좌에서 5000 원이 출금 되었습니다.
예금주: 초기화 메소드 사용
계좌번호: 111-21-8888
현재 잔고: 5000
===================================
예금주: 이름, 계좌번호, 잔고 일일이 다 씀
계좌번호: 312-71-9888
현재 잔고: 9000000
  
 */

class Account{
	
	//멤버변수
	String name;
	String accountNumber;
	int balance;
	
	//멤버메소드
	
	//입금처리: 매개변수로 전달되는 금액만큼 입금
	void deposit(int money) {		
		balance += money;
		System.out.println(money+"원이 입금 되었습니다.");
	}
	
	//출금처리
	void withdraw(int money) {
		//출금을 위해 잔고와 출금액을 비교하여 처리
		if(balance >= money) {
			//잔고가 충분한 경우 출금처리
			balance -= money;
			System.out.println("계좌에서 "+money+" 원이 출금 되었습니다.");
		}
		else {
			System.out.println("잔고 부족으로 출금 불능");
		}
	}
	//계좌조회
	void showAccount() {
		System.out.println("예금주: "+name);
		System.out.println("계좌번호: "+accountNumber);
		System.out.println("현재 잔고: "+balance);
	}//초기화 메소드
	void init(String n, String a, int b) {
		name=n;
		accountNumber=a;
		balance=b;
		System.out.println("기존 잔고: "+balance);
	}
}
public class E04AccountMain {

	public static void main(String[] args) {
		
		Account account = new Account();
		account.init("초기화 메소드 사용", "111-21-8888", 1000);
		account.deposit(9000);
		account.withdraw(5000);
		account.showAccount();
		
		System.out.println("===================================");

		Account account2 = new Account();
		account2.name="이름, 계좌번호, 잔고 일일이 다 씀";
		account2.accountNumber="312-71-9888";
		account2.balance=9000000;
		account2.showAccount();
	}

}
