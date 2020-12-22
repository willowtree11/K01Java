package ex04controlstatement;

public class E01If02 {
/*
 if문
 	형식2
 		if(조건문){
 			조건문이 참일 때 실행 문장;
 			}
 		else{
 			조건문이 거짓일 때 실행 문장;
 			}
 */
	public static void main(String[] args) {

		int num = 101;
		
		if(num%2 ==0) {
			System.out.println("짝수입니다.");			
		}
		else {
			System.out.println("홀수입니다.");
		}

		/*
		 삼항연산자(조건연산자)
		 if~else문과 동일하지만 짧은 코드로 표현이 가능하므로 실무에서 자주 사용되는 문장
		 
		 형식>
		 변수 = (조건식) ? true일때 값 : false일때 값;
		 */		
		
		
		String numberResult1 = (num%2==0) ? "짝수임" : "홀수임" ;
		System.out.println("숫자 "+num+"은 " + numberResult1);
		
		String numberResult2 = (num%2==0) ? "짝수임" : "홀수임";
		System.out.println("숫자 "+num+"은 " + numberResult2);
		
		/*
		
		다중 if문
		
		[시나리오]	 숫자를 홀/짝수인지 먼저 판단한 후 100 이상인지를 판단하는 프로그램을 
		if~else구문을 이용하여 작성하시오	
		 
		 */
		
		int num2 = 120;
		if(num2%2 == 0) {
			if(num2>=0) {
				System.out.println("숫자 "+num2+"은 짝수이면서 100이상");
			}
			else {
				System.out.println("숫자 "+num2+"은 짝수이면서 100미만");
			}
		}
		else {
			if(num2>=100) {
				System.out.println("숫자 "+num2+"은 홀수이면서 100이상");
			}
			else {
				System.out.println("숫자 "+num2+"은 홀수이면서 100미만");
			}
			
		}
	}

}
