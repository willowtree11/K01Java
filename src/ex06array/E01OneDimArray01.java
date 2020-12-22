package ex06array;

public class E01OneDimArray01 {

	public static void main(String[] args) {
		
		/*
		 
		 Java에서는 객체를 통해 배열을 생성하게 된다.
		  생성된 배열은 Heap(힙) 영역에 저장되고, 할당된 메모리의 주소값을 반환한다.
		  그래서 배열명(배열변수)는 주소값(참조값)을 할당받게 된다.
		  해당 주소를 통해 배열에 접근한다.
		  
		 */
		int[] numArr=new int[3];
		numArr[0]=10;
		numArr[1]=20;
		numArr[2]=30;
		
		System.out.println("배열명(numArr)= "+numArr+"(주소값을 문자 형태로 출력한 것. Heap내 참조(주소)값)"); //참조값 출력(I@15db9742)
		System.out.println("numArr 2번 방의 값= "+numArr[2]);  //30 출력
		System.out.println("============================");
		
		/*
		 배열의 선언 및 초기화
		 : 배열은 여러개의 변수를 사용하기 위해 선언하므로 접근을 위해 일반적으로 반복문 사용
		 
		 배열명.length
		 : 해당 배열의 크기를 반환. 배여르이 크기가 변경되는 경우에 유연하게 사용 가능
		 
		 */
		
		
		
		int[] arrNumber=new int[40];
		for(int i=0; i<arrNumber.length; i++) { 
			//length: 데이터를 저장할 수 있는 공간(크기) 
			//arrNumber.length = arrNumber의 크기값을 반환하는 것이므로 해당 예제에서는 '40'을 뜻한다
			arrNumber[i]=i+10;			
		}
		for(int i=0; i<40; i++) {
			System.out.println(i+"번 방의 값="+arrNumber[i]);
		}
		System.out.println("============================");
		
		/*
		
		객체배열
		: 기본자료형을 저장하는 배열이 아닌, 객체의 참조값을 저장할 용도로 생성하는 배열.
		사용 방법은 동일	 
		 
		*/
		
		String[] strArr=new String[3];
		strArr[0]="java";
		strArr[1]="jsp";
		strArr[2]="spring";
		for(int j=0; j<strArr.length; j++) {
			System.out.println(strArr[j]);
		}
		System.out.println("============================");
		System.out.println("배열의 선언과 초기화");
		System.out.println("방법1 : 배열의 선언 이후 초기화");
		int[] initArr=new int[1];
		initArr[0] = 100;
		System.out.println("initArr[0]="+initArr[0]);
		
		
		/*
		 
		 배열의 선언과 동시에 초기화를 하는 경우 자바 컴파일러는 초기값의 갯수를 통해 크기를 결정할 수 있으므로
		 이 경우 크기는 생략하도록 약속되어있다.(크기를 유추할 수 있는 경우 중복기재 금지)
		 
		 */
		System.out.println("방법2 : 선언과 동시에 초기화");
		// int[] initArr2=new int [3] {1, 20, 300}; [에러발생] 
		int [] initArr2=new int [] {1, 20, 300}; 
		
		
		/*
		 
		 배열 요소의 갯수를 통해 배열을 즉시 생성한다. 이때 new 키워드는 생략한다.
		 
		 */
		System.out.println("방법3 : 초기값만으로 선언");
		int[] initArr3= {11,13, 17, 19, 23};
		int arrSum=0;
		for(int x=0; x<initArr3.length; x++) {
			arrSum+=initArr3[x]; //인덱스가 0~4까지 (5개) arrSum에 저장한다는 뜻
		}
		System.out.println("배열요소의 합은="+arrSum);
		
		
	}

}
