package ex16exception;

import java.io.IOException;

//import java.io.IOException;

public class Ex01ExceptionBasic1 {

	public static void main(String[] args) {
		
		/*
		Syntax 에러(구문 에러)
		: 실행 자체가 되지 않는 코드로 오류를 수정해야만 정상적으로 실행된다.
		즉 코드에 문법적인 오류가 발생되었음을 의미한다.
		 
		Int number = 10; // int를 Int로 표기했음 --> 문법부터 오류 syntex에러
		if(true);
		{}
		else // 위에서 if문이 종료되어(세미콜론;) 의미없는 else 문이 되었음
		{}
		*/
		
		//위 문장에서 구문오류가 있는 부분을 수정한 코드
		int number =10;
		if(true) {
			System.out.println("참");			
		}
		else {
			System.out.println("거짓");
		}
		
		/*
		 외부자원을 사용할 때 발생되는 예외
		 
		 처리방법 1] main()함수 밖으로 예외를 던진다 throws IOException '예외던지기' 라고 표현한다
		 내부에서 예외를 처리하지 않고 무시하겠다는 의미
		 public static void main(String[] args) throws IOException {
		 무시가 안되는 오류도 존재한다
		 */
		
		
		/*
		 처리방법2] 예외가 발생된 지점에서 try~catch문으로 직접 예외를 처리한다.
		 */
		try {
			System.out.println("문자 하나를 입력하세요: ");
			int iChar=System.in.read();
		}catch (Exception e) {			
			System.out.println(e.getMessage());
		}
		
	}

}
