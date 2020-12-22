package ex02variable;

public class E05ConstantVar {

	public static void main(String[] args) {

		/*
		 - 상수 :저장된 값이 변하지 않는 메모리의 한 종류
		 - 선언방법 : final 자료형 변수명 = 초기값;
		 	1) 상수는 단 한번만 초기화되고 중간에 값을 변경하면 에러 발생
		 	2) 선언 시 전체를 대문자로 선언하고, 연결되는 단어가 있는 경우 언더바(_)를 사용한다
		 	3) 주로 프로그램 내에서 코드의 가독성을 높여주기 위해 활용
		 */
		
		final double PI = 3.14;
		System.out.println("PI(원주율)="+PI);
		
		//PI = 3.141592; [에러발생] 상수는 단 한번만 초기화되고 중간에 값을 변경하면 에러 발생
		
		final String NICK_NAME;
		//System.out.println("우리는"+ NICK_NAME); [에러발생] 상수의 초기화가 된 적이 없이 출력하려 하면 에러 발생
		NICK_NAME = "코스모71기";
		System.out.println("우리는"+ NICK_NAME);
				
		/*
		가위 바위 보 게임을 제작하기 위해 개발자는 아래와 같이 결정하였다.
		가위: 1, 바위:2, 보: 3 
		 */
		
		final int SCISSOR = 1;
		final int ROCK = 2;
		final int PAPER = 3;
		
		int computer, user;
		/*
		 1과 3은 개발자 본인만 알 수 있는 내용이므로, 가독성이 떨어지는 코드로 작성되었다
		 */
		
		computer = 1;
		user = 3;
		System.out.println("컴퓨터가 이겼습니다.");
		
		/*
		 PAPER와 같은 단어는 누가 보더라도 이해할 수 있으므로 가독성이 높은 명시적인 코드가 된다.
		 */
				
		computer = SCISSOR;
		user = PAPER;
		System.out.println("Coumputer Win");
	}

}
