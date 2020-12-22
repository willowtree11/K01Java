package ex15usefulclass;

/*
equals()메소드
- 	자바에서 인스턴스의 내용비교를 위해 비교연선자(==)를 사용하는 것은
	단순히 참조값에 대한 비교이므로 실제 내용에 대한 비교는 이루어지지 않는다.
-	인스턴스간의 내용 비교를 위해서는 equals()메소드를 각 클래스에 맞게 
	적절히 오버라이딩 하여 사용해야 한다.
-	String과 같은 기본 클래스는 별도의 오버라이딩 없이도 내용비교가 가능하다
 */
class IntNumber{
	int num;
	public IntNumber(int num) {
		this.num=num;
	}
	
	/*
	equals() 메소드가 어떻게 인스턴스간의 내용을 비교하는지 설명하기 위한 코드로 구성
	*/
	public boolean myEquals(IntNumber numObj) {
		//각 멤버변수의 값을 비교해서
		if(this.num==numObj.num) {
			//값이 같을 때는 true반환
			return true;
			
		}
		else {
			//값이 다를때는 false반환
			return false;
		}
	}
}

public class E04Object2MyEquals {

	public static void main(String[] args) {
		
		//기본클래스인 String 클래스의 인스턴스 비교
		String str1=new String("우린 KOSMO");
		String str2="우린 KOSMO";
		
		//별도의 오버라이딩 없이 즉시 사용 가능하다
		if(str1.equals(str2)) {
			System.out.println("같은 문자열 입니다.");
		}
		else {
			System.out.println("다른 문자열 입니다.");
		}
		
		//개발자가 정의한 클래스에 대한 비교		
		IntNumber num1=new IntNumber(10);
		IntNumber num2=new IntNumber(20);
		IntNumber num3=new IntNumber(10);
		
		//개발자가 정의한 myEquals()메소드를 통해 객체간의 값 비교
		if(num1.myEquals(num2)) {
			System.out.println("num1과 num2는 동일한 정수");
		}
		else {
			System.out.println("num1과 num2는 다른 정수");
		}
		
		if(num1.myEquals(num3)) {
			System.out.println("num1과 num3은 동일한 정수");
		}
		else {
			System.out.println("num1과 num3은 다른 정수");
		}
	}
}


