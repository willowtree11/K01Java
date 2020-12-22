package ex05method;

/*

문제1) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오.
파일명 : Qu_04_06.java

실행결과]
*
* *
* * *
* * * *
* * * * *

 */

public class Qu_04_06 {

	public static void main(String[] args) {	
		
		for(int i=1; i<=5; i++) {
			
			for(int j=1; j<i; j++) {
				
				System.out.print("* ");
			}
			System.out.println("* ");
		}
		System.out.println();
	}

}
