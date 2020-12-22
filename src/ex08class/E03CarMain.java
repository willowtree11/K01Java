package ex08class;

class Car{
	
	//멤버 상수
	public static final String AUTO = "자동";
	public static final String MANUAL = "수동";
	
	//멤버 변수
	String carGear = AUTO; //미션
	String carModel; //모델명
	int carYear; //연식
	Human owner; //소유주, Human클래스 기반으로 하는 멤버변수로 
	//초기화를 위해 이름, 나이, 에너지 세 가지의 값이 필요
	//이와 같이 클래스를 구성할 때 또 다른 객체를 멤버 변수로 선언할 수 있다.
	
	//멤버 메소드
	void drive() {
		System.out.println(owner.name+"이(가) "+ carModel+"을 운전한다.");
	}
	
	// 객체의 초기화를 담당하는 메소드로 아래는 항상 같은 값으로만 초기화 된다는 한계를 가지고 있다
	 
	void initialize() { //이상적 형태의 함수가 x, 같은 값으로만 초기화 되기 때문
		carModel = "애스턴마틴";
		carYear = 2017;
		owner = new Human();
		owner.name= "라샤나 린치";
		owner.age=30;
		owner.energy=10;
	}
	
	//위와 동일한 이름의 함수로 오버로딩에 의해 정의된 초기화 메소드.
	//초기화를 진행하는 역할은 동일하나 매개변수를 통해 다양한 형태의 객체를 초기화 할 수 있다.	
	void initialize(String model, int year, String name, int age, int energy) {
		carModel = model;
		carYear = year;
		
		//또다른 객체가 멤버변수로 정의되었으므로, 객체를 생성한 후 각각의 멤버변수를 초기화해야 한다.
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
	}
	
	//해당 객체의 정보를 디스플레이해줌
	void showCarInfo() {
		System.out.printf("[차량정보]");
		System.out.printf("모델명:%s\n", carModel);
		System.out.printf("연식:%d\n", carYear);
		System.out.printf("기어:%s\n", carGear);
		owner.showState(); //Human 클래스에 정의되어있음		
	}
}//end of Car Class

public class E03CarMain {

	public static void main(String[] args) {
		
		//자동차1 객체 생성		
		Car car1 = new Car();
		System.out.println("[초기화 메소드 호출 전]");
		System.out.println("car1.owner= "+car1.owner);
		//car1.drive();
		/*
		 
		  에러발생(자동차 소유주를 표현하는 Human객체가 초기화되지 않은 상태에서 출력을 시도하여
		  런타임 에러가 발생된다. NullPointerException)
		 
		 */
		
		System.out.println("[초기화 메소드 호출 후]");
		car1.initialize(); //고정된 내용으로 초기화 진행됨
		car1.drive(); 
		car1.showCarInfo();
		
		//자동차2 객체 생성: 객체 생성 후 멤버변수에 직접 접근하여 초기화		
		Car car2 = new Car();
		car2.carGear=Car.MANUAL;
		car2.carModel="머스탱";
		car2.carYear=2018;
		
		car2.owner=new Human();
		car2.owner.name="산드라 오";
		car2.owner.age=52;
		car2.owner.energy=10;
		
		System.out.println("자동차 정보와 소유자 정보 같이 보기");
		car2.showCarInfo();
		
		//자동차3 객체 생성: 매개변수가 있는 초기화 메소드를 이용하여 초기화
		Car car3 = new Car();
		car3.initialize("레인지로버", 2012, "디아블로 코디", 42, 10); //초기화
		car3.showCarInfo();	

	}

}
