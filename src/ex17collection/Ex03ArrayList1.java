package ex17collection;

import java.util.ArrayList;
import java.util.Iterator;

/*
ArrayList<E> : List계열의 컬렉션
- 데이터의 중복 저장이 허용
- 데이터의 저장 순서를 보장
- 데이터 접근시 get() 혹은 iterator()를 이용한다
- Array라는 이름처럼 '배열'의 특성을 가지고 있어 index를 통한 저장 및 접근이 가능하다.

*/
public class Ex03ArrayList1 {

	public static void main(String[] args) {
		
		/*
		 List<E> 인터페이스 계열의 컬렉션
		 : ArrayList<T>와 같은 컬렉션은 제네릭을 기반으로 하지만 아래와 같이 타입매개변수를 생략하면
		 모든 객체를 저장할 수 있는 컬렉션이 된다. 즉 ArrayList<Object>로 선언한 것과 동일
		 */
		//ArrayList<String> list = new ArrayList<String>(); 
		//제네릭의 String을 빼면 Object와 같음. 명시성을 위해 삽입
		ArrayList list = new ArrayList();
		
		//1-1] 객체저장
		/*
		 add(객체): 순차적으로 저장하면서 인덱스는 0부터 자동 부여한다.
		 add(인덱스, 객체) : 	인덱스를 직접 부여하여 객체를 저장한다. 
		 					단, 인덱스를 건너뛰면 예외가 발생한다.
		 size(): 컬렉션에 저장된 객체의 갯수를 반호나. 배열의 크기와 동일
		 */
		list.add("블라이매너"); //인덱스0
		list.add("안은영");
		list.add("anne E");
		list.add(3, "굿플레이스");
		//list.add(5, "트링킷"); 에러발생. 인덱스를 건너뛸 수 없다 java.lang.IndexOutOfBoundsException: Index: 5, Size: 4
		list.add(list.size(), "익스플레인");
		list.add(list.size(), "필굿");
		System.out.println("중복 저장 전 객체수: "+list.size());
	
		//1-2] 중복저장
		/*
		List는 배열의 속성을 가지므로 데이터의 중복이 허용된다.
		add()메소드는 추가에 성공한 경우 true를 반환한다.
		 */		
		System.out.println(list.add("anne E")?"중복 저장 됨":"중복 저장 아님"); //삼항연산자
		System.out.println("중복 저장 후 객체수: "+list.size());
		
		//1-3] 리스트 컬렉션 출력하기(for, 확장 for문)		
		System.out.println("\n[일반 for문 사용]");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i)+" "); //인덱스 i가 증가하는것 get메소드 사용
		}
		//컬렉션을 다룰때는 확장for(foreach)문을 주로 사용한다.
		System.out.println("\n[확장 for문 사용]");
		for(Object obj:list) {
			System.out.println(obj+" ");
		}
		//Iterator
		/*
		 1. 컬렉션에 저장된 내용을 Iterator에게 알려주기 위해 객체를 생성한다.
		 2. hasNext()로 반환할 객체가 있는지 검사하고, next()로 해당 객체를 반환한다
		 3. 모든 객체를 반환했다면 false를 반환한다.		 
		 */
		System.out.println("\n[반복자(Iterator) 사용]");
		Iterator  itr=list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		System.out.println("\n=====================\n");
		
		//1-4] 덮어쓰기
		//set(인덱스, 객체) : 특정 인덱스에 저장된 데이터를 덮어쓰게 되므로 기존 자료는 삭제된다.		
		list.set(4, "스트레인지 띵스 덮어쓰기");
		for(Object obj:list) {
			System.out.println(obj+" ");			
		}
		System.out.println("\n=====================\n");
		
		//1-5] 끼워넣기
		//add(삽입할 인덱스, 객체): 해당 인덱스에 삽입하고 기존 데이터는 자동으로 뒤로 밀리게 된다.		
		list.add(4, "해안선이 멀어질 때>끼워넣기");
		for(Object obj:list) {
			System.out.println(obj+" ");
		}
		System.out.println("\n=====================\n");
		
		//1-6] 포함여부 확인
		/*
		 몇 번 인덱스에 있는지는 반환하지 않음.
		 contains(객체): 찾고자 하는 객체가 있는 경우 true를 반환한다.
		 위치한 인덱스까지는 알 수 없다.
		 */
		
		System.out.println(list.contains("안은영")?"안은영 있음":"안은영 없음");
		System.out.println(list.contains("해안선이 멀어질 때")?"해안선이 멀어질 때 있음":"해안선이 멀어질 때 없음");
		
		
		//1-7] 삭제		
		//방법1: 인덱스로 삭제하기
		/*
		remove(index): 인덱스를 통해서 삭제를 진행한 후 삭제가 완료되면 
		정확히 해당 객체를 반환(true or false 아님)
		삭제 후에는 인덱스가 자동으로 재부여된다. 
		삭제 성공 시 해당 객체를 반환하므로 어떤 객체가 삭제되었는지 확인 가능하다.
		 */
		Object obj=list.remove(2);
		System.out.println("삭제된 객체: "+obj);
		
		//방법2
		//indexOf()를 통해 인덱스를 찾은 후 삭제 (주소값 이용해 삭제)

		int index=list.indexOf("안은영");
		System.out.println("안은영의 index="+ index);
		list.remove(index); 
		
		//방법3
		//인스턴스의 참조값을 통해 삭제
		System.out.println(list.remove("필굿")?"삭제 성공":"삭제 실패");
		list.remove("트링킷");
		System.out.println("삭제 후 출력");
		for(Object ob:list) {
			System.out.println(ob+" ");
		}
		System.out.println();
		
		//1-8] 전체삭제
		list.removeAll(list); //방법1
		list.clear(); //방법2
		System.out.println("전체 삭제 후 객체 수: "+list.size());		
	}	

}
