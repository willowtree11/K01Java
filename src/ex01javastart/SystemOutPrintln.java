package ex01javastart;

public class SystemOutPrintln {

	public static void main(String[] args) {
		
		int num1 = 100;
		
		/*
		  System.out.println()
		  	: 내용을 출력한 후 자동으로 줄바꿈 처리를 한다
		  System.out.print()
		  	: 출력 후 줄바꿈 처리를 하지 않는다. 만약 줄바꿈을 하려면 \n 을 추가한다		  	
		  System.out.printf()
		  	: 출력 내용을 서식에 맞춰 출력할 때 사용하며 자체적인 줄바꿈 기능은 없다. 줄바꿈 처리를 위해 \n 또는 %n 두가지를 사용할 수 있다.
		  	%d는 변수 출력 자리 ex> "num1=%d %d %n", num1, num1 -> %d 의 개수만큼 변수 기입 개수를 맞춰야 함.
		 */
		
		System.out.println("num1=" + num1);
		System.out.print("num1=" + num1 + "\n");
		System.out.printf("num1=%d%n", num1);
		
		/*
		 print() 문에서의 +기호의 역할
		 - 숫자끼리는 실제 덧셈 연산을 수행한다
		 - 문자열, 숫자, 변수 등 서로 성격이 다른 데이터끼리는 단순 연결 출력한다		 
		  */
		
		System.out.println(7);
		System.out.println(3.14);
		
		// 숫자와 숫자로 인식하여 실제 덧셈연산의 결과를 출력
		System.out.println(3+5);
		System.out.println(3.5+5.1);
		
		//문자열과 숫자이므로 단순 연결 출력
		System.out.println("3+5="+ 8); //문자열+숫자
		System.out.println(3.15 +"는 실수입니다."); 
		
		//문자열은 연산의 대상이 아니므로 단순 연결 출력
		System.out.println("3+5" + " 의 연산결과는 8입니다.");
		
		//문자열 변수 문자열은 앞뒤 요소가 서로 성격이 다르므로 단순 연결 출력
		System.out.println("num1은 "+ num1 + " 입니다.");

	}

}
