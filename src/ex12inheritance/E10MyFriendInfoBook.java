package ex12inheritance;

import java.util.Scanner;

/*
 
  친구를 표현한 최상위 클래스로 해당 프로그램에서는 Friend클래스로 객체생성은 하지 않는다.
  상속의 목적으로만 정의된 클래스이다.
  
 */
class Friend{
	//멤버변수
	String name; //이름
	String phone; //전화번호
	String addr; //주소
	
	//생성자메소드
	public Friend(String name, String phone, String addr) {
		this.name=name;
		this.phone=phone;
		this.addr=addr;
	}
	
	//멤버메소드
	/*
	 
	  멤버변수 전체정보를 출력하는 메소드
	  
	 */
	public void showAllData() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phone);
		System.out.println("주소: "+addr);
	}
	
	/*
	 간략한 정보만을 출력하는 멤버메소드로, 현재 실행부가 없는 상태로 정의되었다.
	 해당 프로그램에서는 오버라이딩의 목적으로 정의되었다. 
	 */
	public void showBasicInfo() {} //몸체없이 오버라이딩 목적으로 만듦
	
}

/*
 
  고등학교 친구의 전체정보를 출력하기 위해 부모에서 정의된 메소드를 super를 통해 호출,
  자식에서 확장한 변수를 별도의 print문을 통해 출력한다.
  
 */
class HighFriend extends Friend{
	String nickname;
	public HighFriend(String name, String phone, String addr, String nickname) {
		super(name, phone, addr);
		this.nickname=nickname;	
	}
	@Override
	public void showAllData() {
		System.out.println("== 고등학교 친구(전체정보)==");
		super.showAllData();
		System.out.println("별명: "+nickname);
	}
	
	//자식에서 오버라이딩하여 재정의한 메소드로 고등학교 친구의 간략한 정보를 출력 	
	@Override
	public void showBasicInfo() {
		System.out.println("== 고등학교 친구==");
		System.out.println("별명: "+nickname);
		System.out.println("전화번호: "+phone);
	}
}
class UnivFriend extends Friend{
	String major;
	public UnivFriend(String name, String phone, String addr, String major) {
		super(name, phone,addr);
		this.major=major;
	}
	@Override
	public void showAllData() {
		System.out.println("== 대학교 친구(전체정보)==");
		super.showAllData();
		System.out.println("전공: "+major);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("== 대학교 친구==");
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+phone);
	}
}

public class E10MyFriendInfoBook {

	public static void menuShow() {
		System.out.println("*** 메뉴를 선택하세요 ***");
		System.out.println("1. 고등학교 친구 입력");
		System.out.println("2. 대학교 친구 입력");
		System.out.println("3. 전체정보 출력");
		System.out.println("4. 간략정보 출력");
		System.out.println("5. 검색");
		System.out.println("6. 삭제");
		System.out.println("7. 프로그램 종료");
		System.out.print("메뉴선택 >>>");
	}
	
	//프로그램 전반의 흐름에 대해서만 기술하고 관련 함수를 호출하는 정도로만 구성
	public static void main(String[] args) {
		
		//프로그램의 비즈니스 로직을 가진 핸들러 객체를 생성		
		FriendInfoHandler handler
		=new FriendInfoHandler(100);//연락처 정보를 저장할 객체배열의 크기를 100으로 초기화
		
		//무한 루프로 구성하여 사용자가 종료하는 시점에 프로그램 종료됨
		while(true) {
			//메뉴 출력을 위한 메소드 호출
			menuShow();
			Scanner scan=new Scanner(System.in);
			int choice=scan.nextInt();
			
			switch(choice) {
			
			case 1:case 2: //1.고 / 2. 대
				//친구정보 추가
				handler.addFriend(choice);
			break;
			
			case 3:
				//전체정보 출력
				handler.showAllData();
				break;
			case 4:
				//간략정보 출력
				handler.showSimpleData();
				break;
			case 5:
				//친구 정보 검색
				handler.searchInfo();
				break;
			case 6:
				//친구 정보 삭제
				handler.deleteInfo();
				break;
			case 7:
				//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				//main함수의 종료는 프로그램의 종료와 동일하다
				return;
			}
		}////end of while
	}////end of main
}////end of class


//핸들러 클래스: 프로그램의 흐름을 제어할 목적으로 생성한 클래스.
//주로 컨트롤클래스 혹은 핸들러클래스라고 칭한다
//해당 프로그램에서 전반적인 기능을 담당하게 된다
class FriendInfoHandler{
	//멤버변수
	/*
	 Friend타입의 객체배열을 선언하여 하위클래스인 High, Univ객체를 모두 저장한다.
	 부모타입의 배열에는 하위객체 전체를 저장할 수 있으므로 
	 여러개의 객체를 하나의 타입으로 관리할 수 있다는 장점이 있다. 
	 */
	private Friend[] myFriends;
	private int numOfFriends; //정보 추가시 +1 증가(저장된 친구의 명수를 카운트)
	
	//생성자: 인자로 전달되는 num크기의 객체 배열을 생성한다
	public FriendInfoHandler(int num) {
		myFriends=new Friend[num];
		numOfFriends=0;
	}	
	
	//1번째 멤버메소드] 새로운 친구(고등, 대학) 연락처 추가	
	public void addFriend(int choice) {
		Scanner scan=new Scanner(System.in);
		
		String iName, iPhone, iAddr, iNickname, iMajor;
		
		System.out.println("이름: "); iName=scan.nextLine();
		System.out.println("전화번호: "); iPhone=scan.nextLine();
		System.out.println("주소: "); iAddr=scan.nextLine();
			
		/*
		 
		 1. 친구 정보를 입력받은 후
		 2. 객체 배열 0번방에 객체를 저장하고
		 3. numOfFriends 변수를 1 증가시킨다(numOfFriends++후위증가 이유)
		 
		 */
		if(choice==1) {
			//고등학교 친구 입력 후 추가
			System.out.println("별명: "); iNickname=scan.nextLine();
			myFriends[numOfFriends++]=
					new HighFriend(iName, iPhone, iAddr, iNickname);
			/*HighFriend high=
					new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends[numOfFriends++] = high;*/
		}
		else if(choice==2) {
			//대학교 친구 입력 후 추가
			System.out.println("전공: "); iMajor=scan.nextLine();
			myFriends[numOfFriends++]=
					new UnivFriend(iName, iPhone, iAddr, iMajor);
			
		}
		System.out.println("친구 정보 입력이 완료되었습니다.");
	}////end of addFriend
	
	//친구 정보 전체보기 friend 타입 객체배열 high, univfrined 자동형변환
	//(작은쪽이 큰friend쪽으로)
	//실제로는 위에서 오버라이드한 메소드를 호출하게 됨
	public void showAllData() {
		for(int i=0; i<numOfFriends;i++) {
			myFriends[i].showAllData();
		}
		System.out.println("==전체 정보가 출력되었습니다=="); 
	}//end of showAllData
	
	//친구정보 간략보기
	/*
	 
	 1. 고딩친구 정보를 Friend 객체 배열에 추가
	 2. High 객체가 Friend 형으로 자동형변환 되어 저장됨
	 3. 객체배열에 저장된 객체들은 for문을 통해 순차적으로 정보출력,
	 	이 때 오버라이딩 된 메소드를 통해 항상 해당 객체의 정보를 출력할 수 있음.
	 	참조변수의 타입에 영향을 받지 않음
	 
	 */
	public void showSimpleData() {
		for(int i=0; i<numOfFriends;i++) {
			myFriends[i].showBasicInfo();
		}
		System.out.println("==간략 정보가 출력되었습니다==");
	}
	
	public void searchInfo() { //주소록 항목 검색
		boolean isFind=true; //검색한 정보가 있는지 확인하기 위한 변수
		Scanner scan=new Scanner(System.in);
		System.out.println("검색할 이름을 입력하세요: ");
		String searchName=scan.nextLine();
		
		//객체배열에 저장된 친구정보의 갯수만큼 반복
		for(int i=0; i<numOfFriends; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showAllData();
				
				System.out.println("** 귀하가 요청하는 정보를 찾았습니다 **");
				isFind=true; //찾는 정보가 있다면 true로 변경
			}
		}
		
		if(isFind==false)
			System.out.println("** 찾는 정보가 없습니다 **");
	}
	
	public void deleteInfo() { //주소록 항목 삭제		
		Scanner scan=new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요: ");
		String deleteName=scan.nextLine();
		
		/*
		 배열의 요소 중 삭제된 요소의 인덱스 값을 저장할 용도의 변수
		 요소를 삭제한 후 빈자리를 채워넣을 때 사용할 것		  
		 */
		int deleteIndex=-1; //삭제된 데이터에 표식남김, 배열의 index이므로 초기값 -1
		
		for(int i=0; i<numOfFriends; i++) {
			if(deleteName.compareTo(myFriends[i].name)==0){
				//요소를 삭제하기 위해 null값으로 변경
				myFriends[i]=null; //덮어써지기 때문에 안써도 무방하나 완벽하게 없애기 위해 명시적으로 쓰는 것
				//삭제된 요소의 index를 저장
				deleteIndex=i;
				//전체 카운트를 -1 차감
				numOfFriends--;
			}
		}
		if(deleteIndex==-1) {			
			//검색된 데이터가 없어 삭제되지 않았을 때
			System.out.println("==삭제된 데이터가 없습니다==");			
		}
		else {
			/*
			 객체배열에서 검색된 요소를 삭제한 후 입력된 위치의 바로 뒤 요소를 앞으로 하나씩 교환한다.
			 */
			for(int i=deleteIndex; i<numOfFriends; i++) {
				myFriends[i]=myFriends[i+1];
			}
			System.out.println("==데이터("+deleteIndex+"번)가 삭제되었습니다==");
		}
	}//end of deleteInfo
}//end of FriendInfoHandler
