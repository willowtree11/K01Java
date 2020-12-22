package ex12inheritance;

public class DeChild extends DeParent {

	//자식 클래스에서 확장한 멤버변수 stNumber
	String stNumber;//학번
	
	//부모의 인자생성자(괄호 안에 인자가 들어가있는 생성자) 호출
	public DeChild(String name, int age, String stNumber) {
		super(name, age);
		this.stNumber=stNumber;
	}
	
	//자식클래스에서 새롭게 확장한 멤버메소드
	public void study() {//부모가 가지고 있지 않음
		System.out.println(getName()+"이(가) 공부한다.");
	}
	
	//eat메소드는 부모에도 있으니 override? 못함, 부모쪽이 private이라 접근 불가 
	//오버라이딩 대상이 될 수 없다. 그러므로 자식쪽에서 새로 확장한 메소드
	private void eat() {
		
		System.out.println("학생이 먹는다.");
	}
	
	/*
	 
	 메소드 오버라이딩의 조건
	 : 부모클래스에서 선언될 때와 비교해서 접근범위가 동일하거나 그보다 넓으면 가능하다.
	 : 즉 부모엣거 default로 선언했다면 자식에서는 default 혹은 public이면 오버라이딩이 가능
	 
	 */
	//자식쪽 접근범위가 더 넓어야함 부모가 default일때 자식은 public이면 좋음. 같은건 베스트
	@Override
	//오버라이딩의 대상이 될 수 있는 조건: 
	String sleep() { //접근지정자가 반드시 똑같아야 하는가? 똑같은것이 선호됨.
		System.out.println("학생이 잔다");
		return null;
	}
	
	/*
	 
	  메소드의 형태가 부모쪽(protected void walk() )과 다르므로 오버라이딩이 아님
	 오버로딩의 형태로 자식에서 확장한 메소드
	 
	 */
	public int walk(int age) { //부모도 walk 있음, 모양이 다름 void, int 등등.. => 오버로딩임 확장한 함수
		System.out.println("나이가 "+age+"살인 학생이 "+" 산책한다.");
		return 0;
	}
	
	//오버라이딩 메소드 정의
	@Override
	public void exercise() {
		//super.excercise();
		System.out.println("학생이 운동한다.");
	}

	@Override
	public void printParent() {	
		/*
		 
		  super의 두 가지 사용법
		  1. super(): 부모클래스의 생성자 메소드 호출
		  2. super.멤버메소드 : 부모클래스에 정의된 멤버메소드 혹은 멤버변수를 접근할 때 사용
		  
		 */
		super.printParent();
		System.out.printf(", 학번:%s\n", stNumber);
	}
	//static(정적)메소드는 실행되면 초기화되므로 클래스 외부인 메소드영역에 로드가 된다.
	//영역이 달라진다. 그리하여 오버라이딩이 불가하다
	//호출할 때는 각 클래스명을 통해 호출해야 한다
	public static void staticMethod() { //부모와 똑같지만 오버라이딩이 아님 static이기 때문
		System.out.println("학생의 정적 메소드");
	}
}
