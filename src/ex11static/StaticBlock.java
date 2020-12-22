package ex11static;

/*
 
  static 블럭
  : 동일 클래스안의 main메소드보다 먼저 실행되는 블럭으로 main메소드의 실행코드가 없어도 먼저 실행된다.
  단, 다른 클래스에 main이 있는 경우에는 main이 순차적으로 실행되다가 static블럭이 있는 클래스가
  객체화 될 때 실행된다. 이 때, 생성자보다 static 블럭이 먼저 실행된다. 
  
  
 */
public class StaticBlock {
	
	//인수턴스형 멤버	
	int instanceVar;
	void instanceMethod() {}
	
	//정적 멤버
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
	
	//static 블럭
	static {
		
		//블럭 내에서 정적멤버에 접근가능
		staticVar=1000;
		
		/*
		 
		 블럭내에서만 사용할 수 있는 변수로써, 이때는 일반적인 변수를 생성할 수 있다. 
		 
		 */
		int localVar;
		localVar=1000;
		System.out.println("localVar="+localVar);
		
		//인스턴스형 멤버는 블럭내에서 접근할 수 없다.
		//System.out.println("instanceVar="+instanceVar); 에러발생
		//instanceMethod(); 에러발생
		
		
		//정적멤버는 접근 가능
		System.out.println("staticVar="+staticVar);
		staticMethod();
		System.out.println("=====static block======");
		
	}
	
	//생성자 메소드
	/*
	 
	 외부 파일의 main 메소드에서 실행되는 경우 해당 클래스의 객체가 생성자를 통해 생성되기 전에 static블럭이 먼저 실행된다.
	 
	 */
	public StaticBlock() { //멤버변수 초기화
		staticVar=-1;
		System.out.println("===StaticBlock의 생성자===");
	}
	/* main메소드가 외부 파일에 있을 때 실행하기 위해 주석으로 처리함. 주석으로 처리 후 E02StaticBlockMain.java에서 실행할 것
	 * public static void main(String[] args) { System.out.println("===메인메소드==");
	 * //System.out.println("localVar="+localVar); 에러발생, static블럭 내에서 선언된 지역변수이므로
	 * main에서는 사용 불가; }
	 */
}
