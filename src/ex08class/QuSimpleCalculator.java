package ex08class;
/*

문제1) 파일명 : QuSimpleCalculator.java (난이도:하)
기본 4칙연산을 할때마다 연산의 결과와 몇번 수행되었는지를 출력하는 계산기 클래스를 정의해보자.
아래 main함수에 부합하는 CalculatorEx 클래스를 정의하면되고 해당 수치는 임의로 바꿔도 된다.
init() 멤버메소드에서는 계산의 결과를 카운트하는 멤버변수를 0으로 초기화 한다.

*/

class CalculatorEx{
	
	int cntSum=0, cntMin=0, cntMulti=0, cntDivs=0;	//멤버변수 (카운트를 하기 위한 공간)
	
	void init() { //초기화를 위한 멤버 메소드
		cntSum=0;
		cntMin=0;
		cntMulti=0;
		cntDivs=0;
	}
	
	double add(double x, double y) { //x, y main에서 입력받을 수(매개변수)
		cntSum++; //연산 수행시 +1증가 (횟수 카운팅)
		return x+y;
	} 
	
	double min(double x, double y) {
		cntMin++;
		return x-y;
	}
	
	double mul(double x, double y) {
		cntMulti++;
		return x*y;
	}
	
	double div(double x, double y) {
		cntDivs++;
		return x/y;
	}
	
	void showOpCount() { //연산횟수 시각적으로 보여주는 멤버메소드
		System.out.printf("덧셈횟수:%2d\n뺄셈횟수:%2d\n곱셈횟수:%2d\n나눗셈횟수:%2d\n", cntSum, cntMin, cntMulti, cntDivs);
	}
}

public class QuSimpleCalculator {
	public static void main(String[] args)
	{
		CalculatorEx calc = new CalculatorEx();
		calc.init();
		System.out.println("1 + 2 = " + calc.add(1 , 2)); 
		System.out.println("10.5 - 5.5 = " + calc.min(10.5 , 5.5));
		System.out.println("4.0 * 5.0 = " + calc.mul(4.0 , 5.0));
		System.out.println("100 / 25 = " + calc.div(100 , 25));
		System.out.println("10.0 * 3.0 = " + calc.mul(10.0 , 3.0));
		calc.showOpCount();
		
	}	
}
