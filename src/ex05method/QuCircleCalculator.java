package ex05method;

import java.util.Scanner;

public class QuCircleCalculator {
/*
문제5-2) 파일명 : QuCircleCalculator.java (난이도:중)
원의 반지름을 파라미터(매개변수)로 전달하면 원의넓이와 둘레를 계산하여 반환하는 메소드를 각각 정의하자. 이를 호출하는 main 메소드를 정의하라.

(파라미터는 호출해낼 값)
(jsp에서 파라미터 많이 사용할 예정)

메소드명 : circleArea() > 원의넓이, circleRound() > 원의둘레
-넓이공식 : 3.14 * 반지름 * 반지름
-둘레공식 : 2 * 3.14 * 반지름

 */
	
	//원의 넓이 (반환값이 없는 형태->바로 결과 출력)
	static void circleArea(double rad) {
		double result=3.14 * rad * rad;
		System.out.println("원의 넓이: "+result);
	}
	
	//원의 넓이 (반환값이 있는 형태)
	static double circleRound(double rad) {
		double result = 2 * 3.14 * rad;
		return result; //리턴(메인함수에 내용을 넣는)을 할 때는 void 대신 해당 변수형태를 쓴다
	}
	
	public static void main(String[] args) {
		//원의 넓이를 구하는 함수는 반환값이 없도록 설정하였으므로 함수내에서 즉시 결과가 출력됨
		circleArea(10.2);
		
		//원의 둘레를 구하는 함수는 반환값이 있도록 설정하였으므로 값을 반환받아 출력함
		System.out.println("원의 둘레: "+ circleRound(12.3));
	
	
	
//	내가 한 것	
//	static void circleRound(double rad){
//		final double pi=3.14;
//		double cFere= 2.0 * pi * rad;
//		System.out.println(cFere);
//	}
//	
//	static void circleArea(double rad){
//		final double pi=3.14;
//		double cArea= pi * rad * rad;
//		System.out.println(cArea);
//	}
//	
//	public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);		
//		System.out.println("반지름을 입력하세요: ");		
//		double inputRad= scanner.nextDouble();
//		
//		System.out.print("원의 둘레("+ inputRad +") : ");	
//		circleRound(inputRad);
//		
//		System.out.print("원의 넓이("+ inputRad +") : ");		
//		circleArea(inputRad);
		
	}


}
