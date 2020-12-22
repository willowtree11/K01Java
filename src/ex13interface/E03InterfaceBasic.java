package ex13interface;

/*
 인터페이스(Interface)
 - 클래스가 객체의 설계도라면 인터페이스는 클래스의 설계도라 할 수 있다.
 - 자바는 단일상속을 원칙으로 하나 인터페이스를 통해 다중상속을 구현할 수 있다.
 - 추상클래스와 동일하게 상속을 목적으로 제작되므로 구현받은 하위클래스에서 반드시 오버라이딩 해야한다.
 - 멤버로는 추상메소드와 상수로만 구성된다. 변수를 가질 수 없다 final 만 가능
 		메소드: public abstract
 		변수: public staitc final
 -인터페이스는 생성자가 없다.
 */
interface MyInterface1{
	//public MyInterface1() { 에러발생, 생성자 사용 불가
	
	//멤버상수
	public static final int MAX_INT=2100000000;
	double MAX_DBL=1.999999999;
	
	//멤버추상메소드
	public abstract void absFunc1();
	void absFunc2();
}

interface MyInterface2{
	void absFunc2();
}

class simpleClass{
	int simple=1;
	void mySimple() {
		System.out.println("simple="+simple);
	}
}
/*
 인터페이스는 컴마(,)를 이용해 여러개를 동시에 '구현'할 수 있다.
 그리고 '상속' 과 '구현'을 동시에 사용하는 것이 가능하다.
 */
class MyClass extends simpleClass implements MyInterface1, MyInterface2{
	
	@Override
	public void absFunc1() {
		System.out.println("absFunc1() 호출됨");
	}
	/*
	 인터페이스에 동일한 이름의 추상메소드가 존재하는 경우 하나만 오버라이딩 하면 된다.
	 */
	@Override
	public void absFunc2() {
		System.out.println("absFunc2() 호출됨");		
	}
}

public class E03InterfaceBasic {

	public static void main(String[] args) {

		MyInterface1 my1=new MyClass(); //이질화
		
		//오버라이딩 처리 되었기 때문에 자식쪽의 메소드 호출
		my1.absFunc1();
		my1.absFunc2();
	}
}
