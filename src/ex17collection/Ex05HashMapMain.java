package ex17collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 HashMap<K, V>
 : map<T> 인터페이스를 구현한 컬렉션 클래스
 - Key, Value의 쌍을 ㅗ객체를 저장
 - 키 값은 중복될 수 없다. 중복될 경우 덮어쓰기 처리된다.
 - 키 값으로 검색하므로 다른 컬렉션보다 속도가 빠르다
 
 */
public class Ex05HashMapMain {

	public static void main(String[] args) {
		
		//Map 컬렉션 생성. Key와 Value는 String형으로 선언함.
		//HashMap<String, String> map -> 해시맵에 타입매개변수 String, String 타입 이라 읽는다
		HashMap<String, String> map = new HashMap<String, String>();
		
		/*
		 객체저장: 객체저장시 기존에 저장된 동일한 key값이 존재하면 이전 객체가 반환된다.
		 만약 처음이라면 null값이 반환된다.
		 */
		System.out.println("name이라는 키 값으로 저장된 이전의 값: "+map.put("name", "홍길동")); //null 반환
		
		
		
		int number = 20;
		//map.put("age", number); [에러발생] String String 자리인데 숫자number를 넣었기 때문에(value타입 맞지않음) 컴파일 에러
		map.put("age", String.valueOf(number));
		map.put("gender", "남자");
		map.put("address", "가산디지털단지");
		
		//객체수
		System.out.println("\n저장된 객체수: "+map.size()); //객체수는 size 를 쓴다 length 아님
		
		//중복저장		
		//-> 기존에 입력된 name키 값이 있으므로 "홍길동" 이 출력된다. 그리고 기존의 값이 "고길동"으로 갱신된다.		
		System.out.println("\nname이라는 키 값으로 저장된 이전의 값: "+map.put("name", "고길동"));
		System.out.println("키 값으로 중복 저장 후 객체 수: "+map.size());
		
		//출력
		//키 값을 알고 있을 때 출력하기: get(키 값)으로 출력한다.
		System.out.println("\n키 값을 알 때 키 값으로 출력하기: "+map.get("name"));
		
		//키 값을 모를 때 출력하기
		/*
		 1.	Set<T> keySet() 메소드 호출을 통해 키 값들을 Set계열의 컬렉션으로 얻어온다.
		 2.	키 값을 얻어온 후 확장 for문을 통해 저장된 값을 출력한다. 
		 ※  	Map계열의 컬렉션은 처음부터 확장 for문을 사용하는 것이 불가능하다. 위처럼 key값을 먼저 얻어온 후 사용해야 한다. 
		 */
		Set<String> keys=map.keySet();
		System.out.println("\n[확장 for문 적용]");	
		for(String key : keys) {
			String value=map.get(key);
			System.out.println(String.format("%s:%s", key, value));
			
		}
		//반복자를 통한 출력		
		//iterator를 통해 반복할 대도 keySet()으로 먼저 key를 얻어온 후 사용할 수 있다.	
		System.out.println("\n[반복자 사용하기]");
		Set<String> keys2=map.keySet();
		Iterator<String> it=keys2.iterator();
		while(it.hasNext()){
			String key=it.next();
			String value = map.get(key);
			System.out.println(String.format("%s:%s", key, value));
		}
		
		//Value값만 얻어올 때 : value() 메소드 사용
		System.out.println("\n[value값들만 출력하기]");
		Collection<String> values=map.values();
		for(String value : values) {
			System.out.println(value);
		}
		
		//존재유무판단
		//key 혹은 value가 존재할 경우 true가 반환된다.
		System.out.println(map.containsKey("name")?"name 키 값 존재" : "name 키 값 없음");
		System.out.println(map.containsKey("account")?"account 키 값 존재" : "account 키 값 없음");
		System.out.println(map.containsValue("남자") ? "남자 존재" : "남자 없음");
		System.out.println(map.containsValue("여자") ? "여자 존재" : "여자 없음");
		
		//삭제
		//key를 통해 삭제하고, 삭제가 완료되면 해당 value가 반환된다.
		System.out.println("\n삭제된 객체 "+map.remove("age"));
		System.out.println("[age키 값을 삭제 후 출력]");
		for(String key:keys) {
			System.out.println(String.format("%s:%s", key, map.get(key)));
		}
	}

}
