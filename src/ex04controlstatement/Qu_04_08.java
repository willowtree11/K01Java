package ex04controlstatement;

/*
문제3) 다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
파일명 : Qu_04_08.java
 
 */
public class Qu_04_08 {

	public static void main(String[] args) {
		
		
		// *를 출력한 층수를 표현하는 상수
		final int FLOOR =15;
		/*
		 
		 FLOOR-x+1
		 : 변수 x가 증가함에 따라 점점 감소하는 y를 표현하기 위한 일반식 정의
		 
		 */
		
		//세로층 반복
		for (int x=1; x<=FLOOR; x++) {
						
			//가로층 반복
			for(int y=1; y<=(FLOOR-x+1); y++) {  // y<=(FLOOR-x+1) 층마다 하나씩 줄어드는것을 이용한 산술식
				System.out.print("* ");
			}
			System.out.println();
		}
		
//	내가 한 것		
//		for(int i=5; i>=1; i--) {
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
