package ex12inheritance;

/*
 
  오버라이딩(Overriding)
  : 클래스가 상속관계에 있을 때 하위클래스에서 상위클래스의 
  	멤버메소드와 완전히 동일한 모양으로  재정의 하는 것을 말한다
  	오버로딩(Overloading)과 다른점은 매개변수의 갯수,
  	반환타입 등이 완전히 똑같은 형태로 정의한다는 것이다.
  	하위클래스에서 오버라이딩 한 메소드는 상위클래스의 메소드를 가리게 되므로
  	항상 최하위 클래스에서 오버라이딩한 메소드가 호출되게 된다.
  
 */
class Speaker{ //일반적인 스피커를 추상화한 클래스
	private int volumeRate; //음량
	//setter메소드 정의
	public void setVolume(int vol) {
		volumeRate=vol;
	}
	public void showState() { //상속관계에서 오버라이딩을 목적으로 정의한 메소드
		System.out.println("스피커의 볼륨크기: "+volumeRate);
	}
}
//일반적인 스피커의 기능에 중저음 보강된 스피커 추상화
class BaseSpeaker extends Speaker{
	private int baseRate;
	public void setBase(int bas) {
		baseRate=bas;
	}
	
	/*
	 
	 @: Annotation(어노테이션), 자동생성됨, 없어도 문법오류는 생기지 않지만 코드의 명시성을 위해 생성됨
	 @override 오버라이딩 된 메소드에 추가하여 컴파일러에게 알려주는 역할
	 
	 */
	@Override
	public void showState() {
		/*
		 
		  super를 통해 부모클래스에 정의된 멤버메소드를 호출한다.
		  특히 오버라이딩 된 메소드를 호출할 때 super가 없으면
		  재귀함수가 되므로 반드시 필요하다
		  
		 */
		
		super.showState();
		System.out.println("베이스의 볼륨크기: "+baseRate);
	}
}


public class E06overriding {

	public static void main(String[] args) {
		BaseSpeaker baseSpeaker=new BaseSpeaker();
		baseSpeaker.setVolume(10);
		baseSpeaker.setBase(20);
		
		//하위클래스에서 오버라이딩한 showState()메소드가 호출된다
		baseSpeaker.showState();		
		
		System.out.println();
		
		/*
		 
		 부모클래스의 참조변수가 자식클래스의 객체를 참조할 수 있다.
		 이 경우 접근범위는 부모클래스로 제한된다.
		 즉 아래 호출부분에서 speaker 참조변수를 통해서는 
		setBase()메소드는 호출할 수 없다.
		setBase()는 자식클래스에 정의된 멤버메소드이기 때문이다.
		단, 오버라이딩 처리된 메소드가 있는 경우 하위 클래스의 메소드가 호출되게 된다.
		 
		 */
		Speaker speaker = new BaseSpeaker();//부모 객체로 자식을 참조할 수 있다.
		speaker.setVolume(30);
		//speaker.setBase(40); 에러발생 
		//부모는 부모이상을 자식에게서 볼 수 없다 그래서 에러가 발생된다(음량까지만 알기때문에)
		speaker.showState();		
	}
}
