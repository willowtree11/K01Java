package ex03operator;

public class E04LogicOperator {

	/*
	 논리 연산자
	 -&& : 논리 And, 양쪽 모두가 true일 때만 true를 반환하고 나머지는 false 반환
	 -|| : 논리 Or, 한쪽이라도 true이면 true를 반환하고 양 쪽 모두 false 일 때만 false 반환
	 -! : 논리 Not, 반대의 논리를 반환
	 */
	 
	public static void main(String[] args) {

		int num1=10, num2=20;
		
		boolean result1 = (num1==100 && num2==20); // f and t => false
		boolean result2 = (num1<12 || num2>=30); // t or f => true
		
		System.out.println("result1의 결과: "+result1);
		System.out.println("result2의 결과: "+result2);
		
		//num1과 num2가 다를 때 true를 반환한다. 따라서 if블럭이 실행된다
		if(!(num1==num2)) {
			System.out.println("num1과 num2는 다르다");
		}
		else {
			System.out.println("num1과 num2는 같다");
		}
	}

}
