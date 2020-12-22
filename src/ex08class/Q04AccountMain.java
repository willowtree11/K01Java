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

class MyAccount{
	
	String name;
	String accountNumber;
	int balance;
	
	void deposit(int money) {
		balance += money;
		System.out.println(money+"원이 입금되었습니다.");
	}
	
	void withdraw(int money) {
		if(balance >= money) {
			balance -= money;
			System.out.println(money+"원이 출금되었습니다.");
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
	}
	
	void showAccount() {
		System.out.println("예금주: "+name);
		System.out.println("계좌번호: "+accountNumber);
		System.out.println("잔고: "+balance);
		
	}//예금주(name), 계좌번호(accountNumber), 잔고(balance)
	
	void init(String n, String a, int b) {
		
		name=n;
		accountNumber=a;
		balance=b;
		System.out.println("기존 잔고: "+balance);
	}
	
}

public class Q04AccountMain {
	public static void main(String[] args) {
		
		MyAccount myaccount1 = new MyAccount();
		
		myaccount1.init("매러디스", "123-456-78901", 1000);
		myaccount1.deposit(9000);
		myaccount1.withdraw(5000);
		myaccount1.showAccount();
		
		System.out.println("===================================");
		
		MyAccount myaccount2 = new MyAccount();
		
		myaccount2.name="크리스티나";
		myaccount2.accountNumber="741-852-96374";
		myaccount2.balance=9000000;
		myaccount2.showAccount();
		
	}
}
