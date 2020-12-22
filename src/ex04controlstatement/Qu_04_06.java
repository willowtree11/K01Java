package ex04controlstatement;

public class Qu_04_06 {
/*

	문제1) 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오. 
	*
	* *
	* * *
	* * * *
	* * * * *

*/
	public static void main(String[] args) {
		
		int i = 1;
		while(i<=5) {
			
			int j=1;
			while(j<=5) {
				
				if(i>=j) {
					//j는 i의 개수만큼 출력한다
					System.out.print("* ");
				}				
				j++;
			}
			System.out.println(); //한 줄 출력 후 줄바꿈
			i++;
		}


		
		
		
		
		
// 내가 한거 for 문으로 썼음 ㅠㅠ
//		for(int i=1; i<=5; i++) {
//			
//			for(int j=1; j<i; j++) {
//				
//				System.out.print("* ");
//			}
//			System.out.println("* ");
//		}
//		System.out.println();

	}

}
