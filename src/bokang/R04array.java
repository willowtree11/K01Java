package bokang;



public class R04array {
	
	
	public static boolean arrayExistElements(int [] arr) { //배열자체가 아닌 참조값 전달
		
		boolean isDup=true;
		
		//배열 for문 무조건 0부터 시작 왜냐면 인덱스는 0부터 번호가 매겨진다.
		//arr.length 는 arr배열의 크기를 뜻한다. 배열의 크기란 몇 칸인지를 말한다.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				
				if(i!=j) { //자기 자신위치(index)외의 요소와 비교하기 위함					
					if(arr[i]==arr[j]) {
						isDup=false;//중복인 경우 false로 변경.						
					}
				}
				else {
					System.out.println("같은 요소끼리 비교 불가능");
				}
				
			}
		}	
		
		return isDup;		
	}
	
	/*
	연습문제] 중복되지 않는 난수 6개를 생성하시오. 생성한 
	난수는 아래 배열에 채워 넣으시오.
	
	int[] lottoNum = new int[6];
	
	//난수생성 및 중복검사
	 * 난수 6개 만든 후 arrayExistElements 불러서 true값 반환할때만 그 번호를 showArray에서  출력하면 됨.
	randomCreate(lottoNum);
	
	//배열출력
	showArray(lottoNum);
	 */
	
	public static void randomCreate(int[] lottoNum) { //1차원 배열
		
		//1. 난수 6개 생성
		lottoNum[6]=(int)((Math.random()*100)%99)+1; //난수 생성 후 배열저장
		//2. arrayExistElements 로 검사. 적합할때까지 while문으로 무한루프
		//3. 중복 있을 시 다시 난수 6개 생성
		
	}
	
	public static void showArray(int[] lottoNum) {
		//배열 출력
	}
	
	
	
	
	
	public static void main(String[] args) {

		/*
		시나리오]1차원배열을 생성과 동시에 초기화하고 배열의 요소에
		중복값이 있는지 검사하는 프로그램을 작성하시오.
		중복이 없는경우에는 true, 중복이 있는경우에는 false를 반환한다.
		함수명: arrayExistElements
		================================================
		중복체크시에는 이중for문이 필요하다.
		
		ex. 로또, 야구게임 
		 */
		int[] arr1 = new int[] {1,2,3,4,5}; //중복값 x
		int[] arr2 = {1,2,3,2,5}; //중복값 o
		
		//매개변수로 배열변수를 전달하고, boolean값을 반환받음
		boolean isExist1=arrayExistElements(arr1);
		boolean isExist2=arrayExistElements(arr2);		
		
		if(isExist1==true)
			System.out.println("arr1: 중복 없음");		
		else
			System.out.println("arr1: 중복 있음");
		
		if(isExist2==true)
			System.out.println("arr2: 중복 없음");		
		else
			System.out.println("arr2: 중복 있음");
		
		
		/*
		연습문제] 중복되지 않는 난수 6개를 생성하시오. 생성한 
		난수는 아래 배열에 채워 넣으시오.
		 */
		int[] lottoNum = new int[6];
		
		//난수생성 및 중복검사
		randomCreate(lottoNum);
		
		//배열출력
		showArray(lottoNum);		
	}

}
