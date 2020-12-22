package ex12inheritance;
//상속과 생성자 정의
/*
 
문제1) 파일명 :  QuConstructorAndSuper.java
상속관계에 놓여있는 클래스의 생성자 정의 및 호출방식을 기본으로 다음 클래스의 적절한 생성자를 삽입해보자. 그리고 이의 확인을 위한 main 메소드도 적절히 정의해보자.
실행결과]
남은가솔린:10
남은전기량:20
남은워터량:30

 */

class Car
	{
		int gasoline;
	   	public Car(int gasoline) {
		this.gasoline=gasoline;
		System.out.println("Car 생성자 호출");
	}		
}
class HybridCar extends Car
	{
		int electric;
	    
		public HybridCar(int gasoline, int electric) {
			super(gasoline);
			this.electric=electric;
			System.out.println("HybridCar 생성자 호출");
	}		
}
class HybridWaterCar extends HybridCar
{
   	int water;
 
   	public HybridWaterCar(int gasoline, int electric, int water) {
   		//부모클래스로 gas, ele를 전달하여 생성자 호출
   		super(gasoline, electric);
   		//wat로 멤버변수 초기화
   		this.water=water;
   		System.out.println("HybridWaterCar 생성자 호출");
	}

	public void showNowGauge()
   	{
	    System.out.println("남은 가솔린:"+gasoline);
	 	System.out.println("남은 전기량:"+electric);
	 	System.out.println("남은 워터량:"+water);
   	}
}

public class QuConstructorAndSuper {

	public static void main(String[] args)
	{
		//최하위 클래스를 통해 객체생성시 3개의 매개변수 필요함
		HybridWaterCar hcar = new HybridWaterCar(10,20,30);
		hcar.showNowGauge();
	}
}