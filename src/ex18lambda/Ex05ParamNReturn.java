package ex18lambda;

import java.util.Random;

//매개변수 o, 반환값 x
@FunctionalInterface
interface StringConcat{
	public void makeString(String s1, String s2);
}

//매개변수 x, 반환값 o
@FunctionalInterface
interface RandomNumber{
	public int randomNum();
}

//매개변수 o, 반환값 o
@FunctionalInterface
interface GugudanRange{
	public String[][] guguString(int n1, int n2);
}

//매개변수 x, 반환값 x
@FunctionalInterface
interface MenuPrint{
	public void onlyPrint();
}

public class Ex05ParamNReturn {

	public static void main(String[] args) {
		
		System.out.println("### 람다식 1");
		String s1="안녕하세요? ";
		String s2="람다식 입니다.";
		//두 개의 문자열을 받아 연결 후 출력한다.
		StringConcat sc=(a, b) -> {	
			System.out.println(a+""+b);			
		};
		sc.makeString(s1, s2);
		
		
		System.out.println("\n### 람다식2");
		//난수 하나를 생성한 후 반환해준다.
		RandomNumber randomNumber=()->{
			Random random = new Random();
			return random.nextInt(100);
		};		
		int rNumber=randomNumber.randomNum();
		System.out.println("생성된 난수: "+rNumber);
		
		
		System.out.println("\n### 람다식3");
		/*
		 구구단을 문자열형의 2차원 배열에 저장한 후 해당 배열을 반환한다.
		 */
		GugudanRange gugudanRange = (num1, num2) -> {
			
			String[][] gugudan=new String[9][9];
			for(int i=num1; i<=num2; i++) {
				for(int j=1; j<=9; j++) {
					gugudan[i-1][j-1]=i+"*"+j+"="+(i*j);
				}
			}
			return gugudan;
		};		
		String[][] returnStr=gugudanRange.guguString(4, 6);
		//4~6단 범위 출력
		for(int i=4; i<=6; i++) {
			for(int j=1; j<=9; j++) {
				System.out.println(returnStr[i-1][j-1]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("\n### 람다식4");
		MenuPrint menuPrint=()->{
			System.out.println("메뉴를 출력합니다.");
		};
		menuPrint.onlyPrint();
	}

}
