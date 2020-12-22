package ex10accessmodifier;

/*

class를 정의할 때는 반드시 public과 default(기본형-아무것도 쓰지 않은 상태의 생략형태)만 사용하여야 한다.

*/

//private class PrivateClass1 {
//	
//	void myFunc() {
//		System.out.println("나는 정의할 수 없는 Class");
//	}
//} 


/*
 
접근지정자를 생략했으므로 default클래스로 지정된다
해당 클래스는 동일 패키지 내에서만 접근가능하다
  
 */
class DefaultClass1 {
	
	void myFunc() {
		System.out.println("DefaultClass1 클래스의 myFunc()메소드 호출");
	}
}

//public클래슨느 해당 Java파일을 대표하는 클래스로 파일명과 동일하고
//다른 패키지에서도 접근이 가능하다. public 클래스는 하나의 자바파일에 하나만 정의할 수 있다
public class E01AccessModifier1 {

	private int privateVar;
	int defaultVar;
	public int publicVar;
	
	//동일 클래스내에서는 private 멤버여도 접근 가능
	//즉, 동일 클래스 내에서는 접근지정자에 영향을 받지 않는다
	
	private void privateMethod() {
		privateVar=100;
		System.out.println("privateMethod() 메소드 호출");
	}
	void defaultMethod() {
		privateVar=200;
		System.out.println("defaultMethod() 메소드 호출");
	}
	//private으로 선언된 멤버(변수 혹은 메소드)를 외부 클래스에서 접근하고 싶을때는 
	//public으로 선언된 멤버메소드를 이용해서 간접접근 허용
	public void publicMethod() {
		privateVar=300;
		System.out.println("publicMethod() 메소드 호출");
		privateMethod();
	}

}
