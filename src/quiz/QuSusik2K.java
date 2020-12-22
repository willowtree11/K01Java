package quiz;

import java.util.Scanner;

/*
 숫자 n을 입력받아서 아래의 수식을 만족하는 k의 최대값을 구하여 출력하는 프로그램을 작성하시오. 

2^k<=n


가령 n이 20 이라면....k의 최대값은 4가 된다. (2*2*2*2 = 16)
실행결과]
정수n을 입력하세요(0이상의정수):60
공식을 만족하는 k값 : 5 
 */
public class QuSusik2K {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("정수n을 입력하세요(0이상의정수): ");
		int n=sc.nextInt(); //문제에서의 n값
		
		//변수 선언과 초기화
		int k=0;//문제에서의 k값
		int result=2;//2를 거듭해서 곱할 변수
		int inc=1;
		
		if(n==0) {
			System.out.println("만족하는 k값 없음");
			return;
		}
		if(n==0) {
			System.out.println("공식을 만족하는 k값: 0");
			return;
		}
		//방법1
//		while(result <= n) {
//			
//			result*=2;
//			k++;			
//		}
//		System.out.println("공식을 만족하는 k값: "+k);
		
		//방법2
		for(k=0; inc*2<=n; k++) {
			inc=inc*2;
			
		}
		System.out.println("공식을 만족하는 k값: "+k);
	}

}
