package ex06array;

import java.util.Scanner;

public class QuSungJuk {
/*
 
 문제3) 파일명 : QuSungJuk.java
다음 조건에 맞는 프로그램을 작성하시오.
1] 학생수를 사용자로부터 입력받는다.
	-Scanner클래스 사용
2] 입력받은 학생수만큼 국영수 점수를 저장할 수 있는 int형 배열을 선언한다.
3] 다시 학생수만큼 각 학생의 국영수 점수를 입력받아 2]에서 생성한 배열에 저장한다.
	-Scanner클래스 사용
4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력하여라. 
5] 이 문제는 2차원 배열을 활용하는 문제이다.

 
 */
	//과목수를 저장하기 위한 상수 선언
	public static final int SUBJECTS=3;
	
	public static void main(String[] args) {

		//1] 학생수를 사용자로부터 입력받기 (Scanner 클래스 사용)
		Scanner sc=new Scanner(System.in);
		System.out.println("학생수를 입력하세요");
		int numberOfStudent=sc.nextInt();
		System.out.println("학생수:"+numberOfStudent);
		
		//2] 입력받은 학생 수 만큼 국영수 점수를 저장할 수 있는 int형 배열을 선언하고 메모리 할당
		//행의 수: 학생수 , 열의 수: 과목의 수
		int[][]jumsues=new int[numberOfStudent][SUBJECTS]; //스캐너 통해 입력받은 학생 수로 2차원 배열 생성
		
		//과목 타이틀]
		String[] titles= {"국어", "영어", "수학"};
		
		for(int i=0; i <jumsues.length; i++) { //학생수 만큼 반복
			System.out.printf("[%d번째 학생의 점수 입력]%n", i+1);
			//i번째 학생의 국영수 점수 입력 받기
			for(int k=0; k <SUBJECTS; k++) { //과목수 만큼 반복
				System.out.println(titles[k]+"점수 입력?");
				jumsues[i][k]=sc.nextInt();
			}
		}
		
		//4] 각 학생의 국영수 점수 및 총점 그리고 평균을 출력
		System.out.println("================================");
		System.out.printf("%-3s%-4s%-4s%-4s%-4s%s%n","NO","KOR","ENG","MAT","TOT","AVG");
		System.out.println("================================");
		
		
		//점수 배열의 세로크기만큼 반복(학생수)
		for(int i=0; i<jumsues.length; i++) {
			int total = 0;
			
			//NO(학생 번호) 출력
			System.out.printf("%-3d", i+1);
			//과목수 만큼 반복
			for(int j=0; j<SUBJECTS; j++) {
				//각 과목의 합을 구해서 total에 누적함. 즉 총점을 구함
				total += jumsues[i][j];
				System.out.printf("%-4d", jumsues[i][j]); //국영수 점수가 더해진 후 출력
			}
			//총점과 평균을 출력함
			System.out.printf("%-4d %.2f %n", total, (double)total/SUBJECTS);			
		}
		System.out.println("================================");
	}

}
