package ex18lambda;

/*
 람다식(Lambda Expression)
 : 객체지향에서는 메소드를 사용하기 위해서 반드시 클래스를 정의한 후 메소드를 선언해야 한다.
 이러한 불편함 때문에 최근 함수형 프로그래밍(Functional Programming)의 장점이 대두되었고,
 이런 단점을 보완하기 위해 JDK1.8부터 지원하게 되었다.
 
 람다식은 함수에 집중한다.
 인터페이스에 메소드가 하나만 있어야함 안그러면 이름을 생략할 수 없기 때문.(선택을 못하므로)
 */
interface IKosmo3
{	
	void studyLambda(String str);
}

public class Ex03Lambda {

	public static void main(String[] args) {
		
		/*
		 2번 예제에서의 익명클래스를 람다식으로 표현하면 아래와 같다.
		 - 클래스명을 통해 익명클래스를 만드는 부분이 생략된다.
		 - 함수명도 생략한다. 부모에서 오버라이딩하므로 유추할 수 있다.
		 - 매개변수와 {} 사이에 ->(화살표)를 삽입하여 완성한다.
		 */
		
		
		//람다식 기본형태
		IKosmo3 kosmo1=/*클래스명 생략 오버라이딩 생략*/(String str)->{
			System.out.println(str+"을 드디어 써보네요..!!");
		};
		kosmo1.studyLambda("람다식");
		
		
		
		/*
		 위의 람다식을 아래와 같이 한번 더 줄이는것이 가능하다.
		 - 매개변수의 타입을 예상할 수 있다면 생략 가능
		 - 매개변수가 하나라면 소괄호도 생략 가능
		 - 실행할 문장이 하나이고, 동시에 return문이 아니라면 중괄호 생략 가능 
		 */
		//람다식 기본형태보다 더 간소화 된 형태
		//너무 간소화를 많이하면 가독성이 줄어든다는 단점이 있
		IKosmo3 kosmo2 = str -> System.out.println(str+" 완전 간단..!!");
		kosmo2.studyLambda("람다식");
	}

}
