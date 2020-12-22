package quiz;
/*
 다음 수식을 만족하는 모든 A와 Z를 구하는 프로그램을 작성하시오.
  AZ (0~9 사이 정수)
 +ZA (0~9 사이 정수)
--------
  99
단, A와 Z는 서로다른 숫자이다.

 */
public class ExSusikAZ {

	public static void main(String[] args) {
		
		for(int A=0; A<=9; A++) {
			for(int Z=0; Z<=9; Z++) {
				
				if(A==Z) {
					//A와 Z는 서로 다른 숫자이므로 확인 필요 없음 출력x
					continue; //반복문의 처음으로 돌아감
				}
				else {
					//AZ와 ZA를 코드로 표현하면 아래와 같다.
					int result = (A*10+Z) + (Z*10+A);
					//			  AZ      +  ZA
					if(result==99) {
						System.out.printf("%d%d + %d%d = %d\n", A, Z, Z, A, result);
					}
				}
			}
		}
		
		
	}

}
