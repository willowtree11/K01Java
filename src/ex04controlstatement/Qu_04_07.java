package ex04controlstatement;

/*
 
문제2) 1~100까지의 숫자중 3의배수 이거나 7의배수인 숫자의 합을 구하는 프로그램을 작성하시오. 단, 3과 7의 공배수인 경우 합에서 제외해야 한다. 
출력의결과는 누적되는 모든 수를 콘솔에 print한다.
파일명 : Qu_04_07.java

 
 */
public class Qu_04_07 {

	public static void main(String[] args) {
		
		int sum=0; //누적합을 구하기 위한 변수(공간)
		
		//1~100까지 반복
		for(int i=1; i<=100; i++) {
			//3의 배수이거나 7의 배수
			if(i%3==0 || i%7==0) {
				//3과 7의 공배수가 아닌 정수				
				if(i % (3*7)!=0) {
					sum +=i;	
					System.out.print(i+"+");
				}
				//마지막 +기호 빼는거 실습해보기
			}
		}
		
		System.out.println("=" +sum);
		
		
		

		
		
//	기존
//		int sum=0;
//		
//		for(int i=1; i<=100; i++) {
//			
//			if(!(i==3)&&(i%3==0 || i%7==0)&&!(i%3==0 && i%7==0)) {
//				sum+=i;
//				System.out.printf("+%d",i);
//			}
//			else if(i==3) {
//				sum+=i;
//				System.out.printf("%d", i);
//			}			
//		}
//		System.out.printf("=%d", sum);		

	}

}
