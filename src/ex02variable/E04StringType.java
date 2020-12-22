package ex02variable;

public class E04StringType {

	public static void main(String[] args) {
		
		/*
		 기본자료형 : 참&거짓, 문자 ,정수, 실수
		 string은 클래스! 문자열을 담는 기본자료형처럼 쓰이곤 한다
		 형변환이 불가능, 형변환은 기본자료형끼리만 변경 가능한데 string은 class이므로
		 
		 String 타입: 참조형 변수로써 기본자료형이 아님. 문자열을 저장할 수 있는 자료형으로 실제로는 class.
		 Java에서는 문자열을 표현할 때 "큰따옴표로 감싸면 되고, 연결시 +기호 사용
		  */
		
		int number;
		number = 99;
		
		/*
		기본자료형 변수와 참조형 변수 사이에서는 형변환이 불가능. 서로 사용하는 메모리공간이 다르기 때문.
		- 기본자료형: 스택(stack) 영역 사용
		- 참조형(class) : 힙(heap) 영역 사용
		 */
		
		//int stringNumber1 = (int)"100";
		//String stringNumber2 = (String)100;
		
		
		/*
		문자열+정수=> 문자열
		즉, 문자열에 정수가 연결된 형태로 출력
		 */
		
		String strNumber = "100";
		System.out.println(strNumber + number);
		
		/*
		 String은 클래스이므로 new키워드를 이용하여 인스턴스(객체)를 생성한 후 문자열을 참조한다
		  클래스용 변수
		 */
		
		String newString = new String("new 키워드 사용");
		System.out.println(newString);
		
		String stringBasic = "클래스지만";
		String plusString = "기본자료형처럼 사용";
		System.out.println(stringBasic+" "+plusString); //공백" "도 문자에 해당됨
		
		/*
		 문자열+숫자 => 우선 순위가 없다면 일반적으로 문자열로 출력된다. 
		 단, 산술 연산의 결과를 출력하고 싶다면 아래와 같이 소괄호를 이용해서 우선순위를 지정한다
		 */
		
		int kor=100, eng=99, math=98;
		System.out.println("총점: "+kor+eng+math); //(총점: kor) 는 int타입이 아니라 문자열이므로 뒤이은 정수들이 전부 계산이 되지 않고 문자열이 되는 것
		System.out.println("총점: "+(kor+eng+math));
				
	}

}
