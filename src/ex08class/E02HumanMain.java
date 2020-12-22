package ex08class;

//해당 예제에서는 Human클래스를 외부 파일로 선언하였다.
//불러올 클래스(Human)가 동일 패키지 내에 있어서 import선언문이 없다 
//동일 패키지에 정의된다면 컴파일러는 해당클래스를 찾아서 즉시 객체(인스턴스)화 할 수 있다.
//package가 다를때는 import 선언이 필요하다

public class E02HumanMain {

	public static void main(String[] args) {
	
		//1. 객체 생성
		Human human=new Human();
		
		//2. 객체의 초기화
		human.name="마이클";
		human.age=28;
		human.energy=4;
		
		//3. 멤버메소드를 통해 상태 등의 행동을 구현
		human.showState();
		human.eat();
		human.walk();
		human.thinking();
		human.showState();
		
		//4. 에너지를 고갈시켜본다. walk() 메소드 20번 호출
		for(int i=1; i<=20; i++) { //확실히 구동되는지 알기 위해 10보다 큰 수를 씀
			human.walk();
		}
		//5. 에너지가 최대치를 넘는지 확인한다. walk() 메소드 20번 호출
		human.showState();
		for(int i=1; i<=20; i++) {
			human.eat();
		}
		human.showState();
	}	

}
