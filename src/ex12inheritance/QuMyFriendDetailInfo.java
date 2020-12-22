package ex12inheritance;
/*

문제2) QuMyFriendDetailInfo.java
다음 상속관계에 있는 두 클래스의 적절한 생성자를 정의해보자.
main 함수에서는 MyFriendDetailInfo 클래스를 통해서 객체를 생성해야 하고 
생성된 정보를 확인할 수 있도록 해보자.
이름: 이순신
나이: 100
주소: 성균관
전화: 010-1000-8888

*/
class myFriendInfo
{
	private String name;
	int age;
	
	public myFriendInfo(String _name, int _age) {
		name=_name;
		age=_age;
	}	
	
	public void showMyFriendInfo(String name, int age) {
		System.out.println("이름: "+ name);
		System.out.println("나이: "+ age);
	}
}
//친구의 기본정보 외 상세정보를 저장할 클래스
class myFriendDetailInfo extends myFriendInfo
{
	private String addr;
    private String phone;    
    
	public myFriendDetailInfo(String _name, int _age, String _addr, String _phone) {	
		super(_name, _age);
		addr=_addr;
		phone=_phone;
	}
	
	public void showMyFriendDetailInfo()
	{
		//부모클래스의 멤버메소드를 호출할 때 명시적으로 super를 사용하는 것이 좋다.
		super.showMyFriendInfo(addr, age);
		System.out.println("주소: "+ addr);
		System.out.println("전화: "+ phone);
	}
}
class QuMyFriendDetailInfo
{
	public static void main(String[] args)
	{
		myFriendDetailInfo info = new myFriendDetailInfo("이순신", 100, "성균관", "010-1000-88888");
		info.showMyFriendDetailInfo();
	}
}
