package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

public class Qu_04_01 {

	/*
		하나의 문자를 입력받아 사용자가 입력한 값이 숫자인지 판단하여 숫자라면 2의배수인지를 다시 판단하여서 2의배수인 경우에만 "2의 배수 입니다"라고 출력하여라. 
		그 외에는 "2의 배수가 아닙니다" 라고 출력한다.
		힌트] '0'의 아스키코드값은 48 입니다. 
		(System.in.read()를 사용하세요)
	 */
	
	public static void main(String[] args) throws IOException{		
		
		System.out.print("문자 하나를 입력하세요: ");
		int num=System.in.read();
		
		/*
		 아스키 코드를 모를 때 구현하는 방법
		 입력받은 문자가 숫자형 문자인지 판단하여 boolean값 저장 
		 */
		boolean isNumber=(num>='0' && num<='9');
		if(isNumber==true)
		{
			//숫자라면
			//아스키코드번호-0의 아스키코드번호 = 숫자와 동일
			//숫자형 문자가 가지고 있는 아스키코드 값에서 48(0의 아스키코드)을 빼면 해당 문자의 정수가 된다.
			//즉 '4' - '0- = (정수)4
			if((num-'0')%2==0) {
				System.out.println("2의 배수입니다.");
			}
			else {
				System.out.println("2의 배수가 아닙니다.");
			}
		}
		else {
			//숫자가 아니라면
			System.out.println("숫자가 아닙니다");
		}
		
		
		
		
//		 내가 했던 코딩
//		 Scanner scanner = new Scanner(System.in);
//				
//		if(num>='0' && num<='9') {
//			
//			if(num%2==0 && num!=48){
//				System.out.println("2의 배수입니다");
//			}
//			else{
//				System.out.println("2의 배수가 아닙니다");
//			}			
//		}
//		else{
//			System.out.println("숫자가 아닙니다.");
//	
//		}
	}

}
