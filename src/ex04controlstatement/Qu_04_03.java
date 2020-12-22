package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

public class Qu_04_03 {
	
	/*
	
	국어, 영어, 수학 점수를 사용자로부터 입력받아서 평균을 구해  
	90점이상 A학점, 
	80점이상 B학점,
	....
	60점미만 F학점을 출력하는 프로그램을 작성하시오.
	단 switch문을 사용해야 합니다.(Scanner클래스를 사용하세요)

	 */
	
	public static void main(String[] args)  throws IOException{			
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.printf("국어: ");
		int kor=scanner.nextInt();
		System.out.printf("영어: ");
		int eng=scanner.nextInt();
		System.out.printf("수학: ");
		int math=scanner.nextInt();
		
		int avg = (kor + eng + math)/3;		
		System.out.println("평균: "+avg);
					
		System.out.printf("학점: ");		
		
		switch(avg/10) {			
			case 9:
				System.out.println("A");
				break; 
			case 8:
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			case 6:
				System.out.println("D");
			default:
				System.out.println("F");
		}
	}

}
