package ex02variable;
/*
문제2] 파일명 : Qu_02_02.java
국어,영어,수학 점수를 99, 80, 96점으로 입력하고 
평균점수를 구해서 출력하는 프로그램을 작성하시오.
*/
public class Qu_02_02 {

	public static void main(String[] args) {
		
		 int k=99, e=80, m=96;
		 double avg1 = (k+e+m) / 3; // 정수/정수=>결과: 정수
		 double avg2 = (k+e+m) / 3.0; // 정수/실수=>결과: 실수
		 System.out.println("평균점수(정수형):"+ avg1);
		 System.out.println("평균점수(실수형):"+ avg2);
		
		 /*
		  내가 했던 코드
		 double kor=99, eng=80, math=96;
		 System.out.println("평균점수(실수형):"+(kor+eng+math)/3);
		 System.out.println("평균점수(정수형):"+(int)(kor+eng+math)/3);
		 */
		
	}

}
