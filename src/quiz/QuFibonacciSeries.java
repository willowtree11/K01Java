package quiz;

import java.util.Scanner;

/*

문제1) 파일명 : QuFibonacciSeries.java
인자로 전달된 수만큼 피보나치 수열을 출력하는 메소드를 작성하시오.
피보나치수열은 0, 1 부터 시작한다. 따라서 실행결과는 다음과 같다. 
0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ......
실행결과]
출력할 피보나치수열의 항목갯수를 입력하세요:20
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 

=====

배열을 이용해 구하는것이 더 나음.
[변수 이용 시: a=0, b=1, c=a+b => c+b
b=a+b, ...]

====

소셜커머스 등에서 역카운트할때 쓸 수 있는 코드
현재시간-종료시간(미래)=로 나온 시간을 아래 코드로 변환하면 몇시 몇분 몇초 라는것을 보이게 함
*/

public class QuFibonacciSeries {

	public static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {

		
		System.out.println("출력할 피보나치수열의 항목 개수를 입력하세요 : ");
		int fiboCount=scan.nextInt();

		//피보나치 수열 출력을 위한 메소드 호출
		fibonacciFunc(fiboCount);
	
	}
	
	public static void fibonacciFunc(int fCount) {
		
		int f1=0, f2=1, f3;
		
		if(fCount<=1) {
			System.out.println("피보나치 수열은 0, 1 부터 시작이므로 "+"항상 2 이상 입력해야 합니다.");
		}
		else {
			//2 이상의 숫자라면 먼저 0, 1을 출력한다.
			System.out.printf("%d %d ", f1, f2);
			
			
		}
		
		for(int i=1; i<=fCount-2; i++) { //0, 1은  처음부터 입력되게 되므로 2개를 빼고 반복함
			
			//첫번째 수와 두번째 수를 더한 후 곧바로 출력한다.			
			f3=f1+f2;
			System.out.printf("%d ", f3);
			
			//f1, f2에 새로운 값(다음 항목)으로 변경한다.
			f1=f2;
			f2=f3;
			
		}	
		
	}

}
