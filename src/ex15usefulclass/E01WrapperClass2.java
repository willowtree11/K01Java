package ex15usefulclass;

public class E01WrapperClass2 {
	
	public static void main(String[] args) {
			
		/*
		1] parseInt(): 숫자형식의 문자열을 숫자로 변경한다. 주로 웹에서 많이 사용된다.  
		 */
		String strNumber="1000";
		System.out.println("10+strNumber="+(10+strNumber));
		System.out.println("10+strNumber를 숫자로 변경: "+(10+Integer.parseInt(strNumber)));
		System.out.println("10+strNumber를 숫자로 변경: "+(10+Integer.valueOf(strNumber)));
		
		//문자열을 숫자로 변경할 때는 반드시 숫자 형식만 와야 한다.
		//'원'은 숫자가 아니므로 예외 오류가 발생한다.
		String money="120원";
		//System.out.println("120원: "+(Integer.parseInt(money)));
		
		/*
		실수형태의 문자열을 실수로 변경할 때는 praseInt()는 사용할 수 없고
		parseFloat()를 사용해야 한다.
		
		 */
		String floatString="3.14";
		//System.out.println(Integer.parseInt(floatString)); 에러발생
		System.out.println("실수형(float)으로 변경: "+Float.parseFloat(floatString));
		System.out.println("실수형(double)으로 변경: "+Double.parseDouble(floatString));
		
		//Character 클래스의 주요메소드
		/*
		 2] codePointAt(): 문자열에서 특정 index에 해당하는 문자의 아스키코드값을 반환한다.
		 */
		System.out.println("ABCD에서 3번째 인덱스 D의 아스키코드");
		System.out.println(Character.codePointAt("ABCD", 3));
		
		/*
		 3] isDigit(): 인자로 전달된 문자가 숫자인지 판단.
		 숫자일 때 true반환 
		 */
		System.out.println("isDisit()을 통한 숫자판단");
		System.out.println(Character.isDigit('A')?"숫자임":"숫자아님"); //false
		System.out.println(Character.isDigit(50)?"숫자임":"숫자아님"); //true
		System.out.println(Character.isDigit('7')?"숫자임":"숫자아님"); //true
		
		/*
		 4] isLetter(): 인자로 전달된 문자가 문자인지 판단. 특수기호나 숫자형은 false반환한다. 
		 */
		System.out.println("isLetter()메소드를 통한 문자판단");
		System.out.println(Character.isLetter('가')); //true
		System.out.println(Character.isLetter('A')); //true
		System.out.println(Character.isLetter('#')); //false
		System.out.println(Character.isLetter('9')); //false
		
		/*
		 5] isWhitespace(): 인자로 전달된 문자가 공백문자인지 판단.
		 */
		System.out.println("isWhitespace() 메소드로 공백문자 판단");
		System.out.println(Character.isWhitespace('A')); //false
		System.out.println(Character.isWhitespace(' ')); //true
		
		/*
		 6] isLowerCase(), isUpperCase(): 인자로 전달된 문자의 대/소문자여부 판단. 일치하지 않을시, 알파벳이 아닐시 false
		 */
		System.out.println("알파벳 대소문자 판단");
		System.out.println(Character.isLowerCase('A')); //false
		System.out.println(Character.isUpperCase('z')); //false
		System.out.println(Character.isLowerCase('a')); //true
		System.out.println(Character.isUpperCase('Z')); //true
		System.out.println(Character.isLowerCase('가')); //false
		
		/*
		 시나리오 ] 주어진 문자열안에 몇 개의 공백문자(스페이스)가 있는지 판단하는 프로그램을 작성하시오.
		 참고> toCharArray(): 문자열을 char형 배열로 반환해주는 String 클래스에 정의된 메소드 
		 
		 */
		
		String whiteString=" H    E L      L      O ";
		//System.out.println(whiteString.toCharArray());
		
		int whiteCount=0;
		// 주어진 문자열을 char형 배열로 변환한다
		char[] chArr=whiteString.toCharArray();
		// 배열의 크기만큼 반복한다
		for(int i=0; i<chArr.length; i++) {
			//각 index의 문자가 공백인지 검사한다
			if(Character.isWhitespace(chArr[i])) {
				//공백 문자인 경우 +1 증가한다
				whiteCount++;
			}			
		}
		System.out.println("총 공백문자의 수: "+whiteCount);
		
		
	}	
	

}
