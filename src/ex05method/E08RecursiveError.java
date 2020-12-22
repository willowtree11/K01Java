package ex05method;

public class E08RecursiveError {

	public static void main(String[] args) {
	showHi(3);		
	}
	
	/*
	 
	 오류코드
	 1. 감소 연산자로 인해 cnt의 값은 차감됨
	 2. 그러나 조건식의 위치가 잘못됨
	 3. 재귀 호출을 하기 전에 종료 체크를 할 수 있도록 수정해야 함
	 
	 StackOverflow(스택오버플로우)
	 : 스택은 함수가 종료되기 전까지의 모든 정보를 저장하는 메모리로,
	 유한한 공간이므로 무한루프에 빠지게 되면 저장 능력을 초과하여 해당 에러가 발생
	 
	 
	 */
	
	
	public static void showHi(int cnt) {
		System.out.println("Hi~");
		System.out.println("cnt="+cnt);
		
		
		if(cnt==1) {
			return;
		}
		showHi(--cnt); //위치 변경
		//showHi(cnt--); 
		//감소연산자가 뒤에 있게되면 cnt의 값이 감소하기 전 함수를 호출하게 되므로(계속해서 3만 호출되므로) 
		//우선순위가 잘못되어 똑같이 StackOverflowError 유발 
	}
	/*
	 * 오류코드
	 * public static void showHi(int cnt) { System.out.println("Hi~");
	 * System.out.println("cnt="+cnt);
	 * 
	 * showHi(--cnt); //스택은 데이터가 빠져나가야 저장이 되나 계속 쌓이기만 해서 StackOverflowError 유발
	 * 
	 * if(cnt==1) { return;
	 * } }
	 */

}
