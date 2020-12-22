package ex07string;

public class E02StringMethod {

	public static void main(String[] args) {

		System.out.println("String 클래스의 주요 메소드");
		
		String str1="Welcome to Java";
		String str2="자바야 놀자!";
				
		// 1] length(): 문자열의 길이를 반환한다.
		
		System.out.println("str1의 길이(공백포함): "+str1.length());
		System.out.println("str2의 길이(공백포함): "+str2.length());
		
		
		// 2] charAt(인덱스): 문자열에서 특정 index에 해당하는 문자 하나를 반환한다. index는 0부터 시작한다
		
		System.out.println("str1의 두번째 문자: "+str1.charAt(1));
		System.out.println("str2의 두번째 문자: "+str2.charAt(1));
		

		
		/*
		  
		 시나리오] 주민등록번호를 이용하여 성별을 판단하는 프로그램을 작성하시오
		 190419 - 3000000=>남자
		 190419 - 4000000=>여자
		 
		 */
		
		String juminNum="190419-5000000";
		if(juminNum.charAt(7)=='1' || juminNum.charAt(7)=='3') {
			System.out.println("남자입니다");
		}
		else if(juminNum.charAt(7)=='2' || juminNum.charAt(7)=='4') {
			System.out.println("여자입니다");
		}
		else if(juminNum.charAt(7)=='5' || juminNum.charAt(7)=='6') {
			System.out.println("외국인입니다");
		}
		else {
			System.out.println("주민번호가 잘못되었습니다.");
		}
		
		
		// 3] compareTo(): 두 문자열의 첫번째 문자부터 순차적으로 비교하면서
		// 앞의 문자열의 아스키코드가 크면 양수를 반환, 뒤의 문자열이 아스키코드가 크면 음수를 반환
		// 같으면 0을 반환한다.
		
		String str3="A";
		String str4="B";
		System.out.println(str3.compareTo(str4)); //-1
		System.out.println(str4.compareTo(str3)); //1
		System.out.println("ABC".compareTo("ABC")==0 ? "문자열이 같다":"문자어ㅕㄹ이 다르다");
		
		// 4] concat(): 두 개의 문자열을 연결할 때 사용한다. +기호와 동일한 역할
		System.out.println("JAVA".concat("WORLD").concat(" Go"));
		System.out.println("JAVA"+"WORLD"+" Go");
		
		// 5] contains(): 문자열에 특정 문자열이 포함되어 있는지를 판단하여 포함되어있으면 true반환
		
		System.out.println(str1.contains("To"));
		System.out.println(str1.contains("To"));
		
		/*
		 
		 시나리오] 해당 문자열이 이메일 형식인지 검사하는 프로그램을 작성하시오.
		 hong@ikosmo.co.kr => 이메일 형식임
		 not@naver => 이메일 형식이 아님
		 
		 */
		
		//String email="hong@ikosmo.co.kr";
		String email="not@naver";
		if(email.contains("@") && email.contains(".")) {
			System.out.println("이메일 형식임");
		}
		else {
			System.out.println("이메일 형식이 아님");
		}
		
		// 6]endsWith() : 문자열이 특정 문자열로 끝나면 true, 아니면 false 반환
		// 7]startsWith(): 문자열이 특정 문자열로 시작하면 true, 아니면 false 반환
		
		System.out.println("www.daum.net".endsWith("net")); //true
		System.out.println("naver.com".startsWith("http")); //false
		
		
		// 8] format(): 출력형식을 지정하여 문자열로 반환하고 싶을 때 사용
		//printf()와 사용법은 동일하고 주로 웹어플리케이션(JSP)를 제작할 때 많이 사용된다
		
		System.out.printf("국어:%d, 영어:%d, 수학:%d\n", 81, 92, 100);
		//위 아래 문 둘 다 결과 똑같음
		String formatStr=
				String.format("국어:%d, 영어:%d, 수학:%d\n", 81, 92, 100);
		System.out.println(formatStr);
		
		
		// 9] indexOf(): 문자열에서 특정 문자열의 시작인덱스를 반환한다. 만약 찾는 문자열이 없다면 -1을 반환한다.
		
		System.out.println(str1.indexOf("ava")); //Welcome to j'ava'
		System.out.println(str1.indexOf("J"));
		System.out.println(email.indexOf("@")!=-1 ? //contains의 역할 대체수행
				"이메일 형식 맞음" : "이메일 형식 아님");
		
		
		//시나리오] indexOf를 사용하여 주민등록번호에서 성별구분하는 프로그램 작성
		//'-'(하이픈)의 위치를 찾아 +1하면 성별에 해당하는 문자를 얻을 수 있음
		juminNum="120403-3012345";
		int index=juminNum.indexOf("-")+1;
		if(juminNum.charAt(index)=='3') {
			System.out.println("남자");
		}
		else {
			System.out.println("여자");
		}
		
		// 10] lastIndexOf(): 사용법은 indexOf()와 동일하나
		// 문자열의 뒤에서부터 문자열을 찾아서 인덱스를 반환한다
		
		System.out.println(str1.lastIndexOf("ava"));
		System.out.println(str1.lastIndexOf("J"));
		System.out.println("indexOf: "+str1.indexOf("a"));
		System.out.println("lastIndexOf: "+str1.lastIndexOf("a"));
		
		// 11] replace: 특정 문자열을 찾아서 지정된 문자열로 변경한다.
		//만약 찾는 문자열이 없다면 변경만 되지 않을 뿐 에러가 발생하지는 않는다.
		
		System.out.println("J를 G로 변경하기");
		System.out.println(str1.replace("J", "G"));//변화없음-대문자가 없음
		System.out.println("java를 KOSMO로 변경하기");
		System.out.println(str1.replace("java", "KOSMO"));//변환됨
		
		// 12] split(): 문자열을 구분자를 통해 분리해서 String 타입의 배열로 반환한다.
		//해당 구분자가 없는 경우에는 크기가 1인 배열로 반환된다.
		
		String phoneNumber="010-1234-5678";
		String[] phoneArr=phoneNumber.split("-"); //구분자 '-', JSP에서 많이 쓰임
		for(int i=0; i<phoneArr.length;i++) {
			System.out.printf("phoneArr[%d]=%s\n", i, phoneArr[i]);
		}		
		
		// 13] substring(): 시작인덱스와 끝인덱스 사이의 문자열을 잘라서 반환함
		// 즉 문자열을 자를 때 사용하는 메소드
		// 사용 1: substring(index) -> 이 경우 index부터 문자열의 끝까지를 잘라내어 반환
		// 사용 2: substring(index1, index2) -> index에 포함되는 부분만 잘라내어 반환
		System.out.println(str1.substring(3));
		System.out.println(str1.substring(3, 7));
		
		/*
		 시나리오] 다음 파일명에서 확장자를 잘라내는 프로그램을 작성하시오
		 파일명: my.file.images.jpg 
		 */
		
		String filename="my.file.images.jpg";
		int beginIndex=filename.lastIndexOf(".")+1; //점의 위치에서 찾아내기
		System.out.println("파일의 확장자는: "+filename.substring(beginIndex));
	}

}
