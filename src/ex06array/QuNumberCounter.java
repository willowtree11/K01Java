package ex06array;

public class QuNumberCounter {

	/*
 문제1) 파일명 : QuNumberCounter.java
다음에 주어진 answer 배열에는 1~4까지의 정수가 여러개 저장되어 있다. 
배열 전체의 데이터를 읽어서 각 정수가 몇개씩 있는지 카운트하여 counter 배열에 순서대로 저장하시오.

샘플코드]
int[] answer = { 1,4,4,3,1,4,4,2,1,3,2  };
int[] counter = new int[4];

실행결과]
counter[0] => 3
counter[1] => 2
counter[2] => 2
counter[3] => 4
 
 */
	public static void main(String[] args) {
		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 }; //선언과 동시에 초기화 진행됨. 크기 정해짐
		
		//선언만 진행되었고 초기화 진행되어있지 않음
		//=> 크기가 기본값으로 채워짐 기본값 정수형 0, 실수형 0.0, 객체배열=null
		int[] counter = new int[4];	
		
		//배열의 크기만큼 반복하면서 각 요소를 읽어온다
		for(int i=0; i<answer.length; i++) { 
			/*
			
			if(answer[i]==1) counter[0]++; //if문의 실행할 문장이 1줄이면 중괄호{} 생략 가능
			else if(answer[i]==2) counter[1]++; 
			else if(answer[i]==3) counter[2]++; 
			else if(answer[i]==4) counter[3]++; 
			//if로만 반복시키면 각각의 조건들을 매번 체크하지만 else if로 하면 체크횟수가 줄어들게 됨(하나의 if문만) - 퍼포먼스향상
			
			 */
			
			//위 주석 내 if~else문을 한 문장으로 축약시
			//검색한 숫자가 만약 1이라면 counter 배열의 0번번 인덱스를 +1증가 시키므로
			//아래와 같이 표현할 수 있다.
			counter[answer[i]-1]++; 
		}
	
		//counter 배열 출력
		for(int i=0; i<counter.length; i++) {
			System.out.printf("counter[%d] '%d'의 갯수:%d\n", i, i+1, counter[i] );
		}
	}
	
}
