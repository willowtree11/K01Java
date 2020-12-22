package ex05method;

import java.util.Scanner;

public class QuSimpleOperation {

	static void arithmetic(int a, int b) {
		System.out.printf("덧셈결과:%d+%d=%d\n ", a,b,(a+b));				
		System.out.printf("뺄셈결과:%d+%d=%d\n ", a,b,(a-b));
		System.out.printf("곱셈결과:%d+%d=%d\n ", a,b,(a*b));
		System.out.printf("나눗셈몫결과:%d+%d=%d\n ", a,b,(a/b));
		System.out.printf("나눗셈나머지결과:%d+%d=%d\n ", a,b,(a%b));
		//%기호를 콘소렝 출력하기 위해 이스케이프 시퀀스를 사용함.
	}
	
	public static void main(String[] args){
		
		arithmetic(10, 20);
		
	
	
// 기존	
//	static void arithmetic(int num1, int num2) {
//		if(num1>=0 && num2>=0) {
//
//			System.out.println("덧셈결과 " + "->" + (num1+num2));				
//			System.out.println("뺄셈결과 " + "->" + (num1-num2));
//			System.out.println("곱셈결과 " + "->" + (num1*num2));
//			System.out.println("나눗셈 몫 " + "->" + (num1/num2));
//			System.out.println("나눗셈 나머지 " + "->" + (num1%num2));
//		}
//		else {
//			System.out.println("두 숫자 모두 0 이상의 양의 정수를 입력해 주세요");
//		}	
//	}
//	public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);	
//		System.out.println("두 개의 정수를 입력하시오");
//		
//		System.out.println("첫번째 정수: ");
//		int inputNum1= scanner.nextInt();
//		
//		System.out.println("두번째 정수: ");
//		int inputNum2= scanner.nextInt();
//		
//		arithmetic(inputNum1, inputNum2);		

	}


}
