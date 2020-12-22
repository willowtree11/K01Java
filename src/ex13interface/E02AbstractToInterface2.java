package ex13interface;
/*
 추상클래스를 interface로 변경하기
 
 abstract class=> interface
 
- 메소드의 경우 public abstract를 제거
- 멤버상수의 경우 public static final을 제거한다.
 
 */
interface PersonalNumberStroageInter{
	void addPersonalInfo(String juminNum, String name);
	String searchPersonalInfo(String juminNum);
}

class PersonalInfoVO{
	//멤버변수 - private 선언
	private String name;
	private String juminNum;
	//생성자
	public PersonalInfoVO(String name, String juminNum) {
		this.name=name;
		this.juminNum=juminNum;		
	}
	//getter 메소드 - private 멤버를 반환하는 용도
	String getName() {return name;}
	String getJuminNum() {return juminNum;}
}

/*
클래스가 클래스를 상속할 때 => extends
클래스가 인터페이스를 상속받을 때 => implements
인터페이스가 인터페이스를 상속할 때 => extends

extends는 '상속' , implements 는 '구현' 
 */
//인터페이스 상속은 '구현'implements 이라는 표현을 쓴다
class PersonalNumberStorageImpl implements PersonalNumberStroageInter{
	
	//멤버변수
	PersonalInfoVO[] personalArr;//정보저장용 객체배열
	int numOfPerInfo;//입력정보 카운트용 변수
	//생성자
	public PersonalNumberStorageImpl(int arrSize) {
		personalArr=new PersonalInfoVO[arrSize];
		numOfPerInfo=0;
	}
	
	//상속을 통해 추상메소드를 포함하게 되었으므로 반드시 override 해야한다(필수)
	//전달받은 인자를 통해 DTO객체를 생성한 후 객체배열에 추가함 
	
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo]=new PersonalInfoVO(name, juminNum);
		numOfPerInfo++;
	}
	
	//주민번호를 인자로 전달받아 객체배열에 저장된 정보를 검색한 후 일치하는 경우에만 이름 반환
	@Override
	public String searchPersonalInfo(String juminNum) {
		for(int i=0; i<numOfPerInfo; i++) {
			//멤버변수가 private이므로 getter를 통해 반환받음
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0)
			{
				return personalArr[i].getName();
			}
		}
		//검색결과가 없을 때는 null 반환함.
		return null;
	}
}

public class E02AbstractToInterface2 {

	public static void main(String[] args) {
		
		//객체생성
		PersonalNumberStorageImpl storage=new PersonalNumberStorageImpl(10);
		
		//정보저장
		storage.addPersonalInfo("901234-2222222", "김태희");
		storage.addPersonalInfo("901234-1111111", "정지훈");
		
		//검색
		System.out.println(storage.searchPersonalInfo("901234-2222222"));
		System.out.println(storage.searchPersonalInfo("901234-1111111"));
		System.out.println(storage.searchPersonalInfo("001024-1090333"));
	}

}
