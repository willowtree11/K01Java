package bokang;

import bokang.sub.CheckCard1;
import bokang.sub.CheckCard2;
import bokang.sub.CheckCard3;

public class R05Class {

	public static void main(String[] args) {

		//체크카드 클래스 ver01
		/*
		 숫자를 구분할 때 구분자로 언더바를 사용할 수 있다.
		 JDK 7.0부터 지원되었으며 숫자 사이에 쓰는 것만 허용된다.
		 잘못된 방식]
		 3._112312
		 123_456_
		 _123_456
		 위와 같이 언더바로 시작하거나 끝날 수 없고, 소수점과 연결해서도 사용할 수 없다.
		 */
		CheckCard1 cc1 = new CheckCard1();
		cc1.cardNumber=1111_2222_3333_4444L; //long타입처럼 긴 숫자는 가독성이 떨어지므로 언더바로 구간나누는게 허용된다
		cc1.owner="홍길동";
		cc1.balance=10000;
		cc1.point=0;
		
		//5000원 결제
		cc1.payment(5000);
		
		//10000원 결제
		cc1.payment(10000);
		
		//현재 상태 보기
		cc1.showState();
		
		/********************************************************************************************************/
		
		//객체생성 후 초기화 메소드를 통해서 멤버면수 초기화
		CheckCard2 cc2=new CheckCard2();
		cc2.initMembers(1234_5678_9012_3456L, "안은영", 3000, 0);
		
		//인자생성자를 통해 객체생성과 동시에 멤버변수 초기화
		CheckCard2 cc3=new CheckCard2(9876_5432_1098_7654L, "정세랑", 100000, 0);
		
		cc2.charge(8000);
		cc2.payment(9000);
		cc2.showState();
		
		/*
		cc2.balance=9900;
		cc2.owner=9900;
		private멤버 직접 접근불가
		*/
		
		//정보 은닉된 멤버에 접근시에는 setter를 통해서만 가능하다.
		cc2.setBalance(9900);
		cc2.setOwner("김초엽");
		cc2.showState();
		
		cc3.charge(500);
		cc3.payment(1000000);
		cc3.showState();
		
		/********************************************************************************************************/
		System.out.println("체크카드3");
		CheckCard3 ccc3=new CheckCard3(9876_5432_1098_7654L, "정세랑", 100000, 0);
		cc3.charge(500);
		cc3.payment(1000000);
		cc3.showState();
	}
}
