package ex04controlstatement;

/*
 
 while문
 : 반복의 횟수가 정해져있지 않을 때 주로 사용하는 반복문.
 반복의 횟수가 명확할 때는 주로 for 문을 사용한다
 형식] 반복을 위한 변수의 초기값 선언;
 while(반복의 조건){
 	실행문;
 	반복을 위한 변수의 증감식; <=반복문 탈출을 위한 
 						 ++, --와 같은 연산이 필요
 	}
 반복의 조건이 false일 때 while문을 탈출한다
 
  */
public class E03While {

	/*
	 시나리오] 1~10까지의 합을 구하는 프로그램을 while문으로 작성하시오 암기~~
	 */
	
	public static void main(String[] args) {

		//누적 합을 저장하기 위한 변수 선언
		//증가하는 i를 누적해서 더함
		int sum=0;
		//반복을 위한 변수선언 및 초기화
		int i=1;
		while(i<=10) { //반복의 조건 설정. i가 11이상이면 탈출
			//증가되는 i를 sum에 누적해서 더함(1+2+3+ ...
			sum += i;
			//while문을 탈출하기 위한 조건을 위한 증가연산
			i++;
		}
		System.out.println("1~10까지의 합은: "+sum+"\n"); //결과 : 55

		
		
		/*
		 시나리오] 1부터 100까지의 정수 중 3의 배수이거나 5의 배수인 수의 합을 구하는 프로그램을
		  while문을 이용해 작성하시오
		 */
		int total = 0;	
		int j=1;
		while(j<=100) {
			//3의 배수 혹은 5의 배수
			if(j%3==0 || j%5==0) {
				total += j;	//total+j;				
			}
			j++;
		}
		System.out.println("1~100까지의 3의 배수 또는 5의 배수 합은: "+total+"\n");
		
		
		
		int dan=2; //2단 부터 시작
		while(dan<=9) { //2단에서 9단 까지 증가
			int su=1; //수(하나의 단을 출력한 후 단이 증가하면 수는 1로 초기화)
			while(su<=9) { //수는 1에서부터 최대  9까지 증가
				//서식에 맞춰(table모양) 출력할 때는 printf()문이 유리
				System.out.printf("%-2d*%-2d=%2d", dan, su, (dan*su));
				//System.out.print(dan+"*"+su+"="+(dan*su));
				//코드 정렬을 맞춰야 차후 유지보수시 리뷰가 편함
				//-2d 등으로 숫자 나열을 보기 편하게(table 형태로) 미리 정리해두는것이 좋음
				System.out.println(" ");
				su++;
			}
			//하나의 단을 모두 출력한 후 다음 단을 출력하기 위해 줄바꿈 처리
			System.out.println();
			dan++; //단 증가
		}	
		System.out.println("\n=============================\n");
	
		/*
		 시나리오] 아래와 같은 모양을 출력하는 while문을 작성하시오
		 출력결과
		 	1 0 0 0
		 	0 1 0 0 
		 	0 0 1 0
		 	0 0 0 1
		 */
		int m=1;
		while(m<=4) {
			
			int n=1;
			while(n<=4) {
//				System.out.println(m+" "+n);
				if(m==n) {
					System.out.print("1 ");					
				}
				else {
					System.out.print("0 ");
				}
				n++;
			}
			System.out.println();
			m++;
		}
	}

}
