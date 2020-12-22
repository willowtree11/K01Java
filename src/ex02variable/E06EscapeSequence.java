package ex02variable;

public class E06EscapeSequence {

	public static void main(String[] args) {

		// \t 탭(tab), 스페이스 4칸
		System.out.println("4월엔 벚꽃~~!");
		System.out.println("4월엔\t벚꽃~~!");
		
		//줄바꿈(Line feed) 기능
		System.out.println("KOSMO에 오신걸 환영합니다.\n");
		System.out.println("열심히\n해봅시다.\n");
		
		//문장 내 큰따옴표 표현 필요시 \"
		//System.out.println("나는 "개발자"가 되고싶어요");
		System.out.println("나는 \"개발자\"가 되고싶어요");
		
		//printf() : 문자열을 서식에 맞춰 출력할 때 사용, +기호 없이 순차로 문자열 연결 가능
		int kor=81, eng=97, math=79;
		
		/*
		 자리수 지정하기
		 Ex)	%4d : 정수 출력 시 전체 자리수를 4자리로 표현
		 		%6.2f : 실수 출력 시 전체 자리수는 6자리, 소수점 이하 2자리로 표현. 양수는 우측정렬, 음수는 좌측정렬됨
		 */
		
		System.out.printf("국어:%d, 영어:%d, 수학:%d%n", kor, eng, math);
		System.out.println("\n국어:" + kor + ", 영어:" + eng + ", 수학:" + math);
		double avg = (kor+eng+math) / 3.0;
		System.out.printf("평균점수: %f%n", avg); //실수 %f
		System.out.printf("국어:%d, 영어:%d, 수학:%d, 평균:%f %n", kor, eng, math, avg);
		
		//문자열이 들어갈 공간을 확보 후 좌/우측 정렬(table같은 기능 , .2를 붙이면 소수점 2자리까지 표현한다는 뜻)
		System.out.printf("국어:%6d, 영어:%6d, 수학:%6d, 평균:%7.2f %n", kor, eng, math, avg);
		System.out.printf("국어:%-6d, 영어:%-6d, 수학:%-6d, 평균:%-7.2f %n", kor, eng, math, avg);
		
		
	}

}
