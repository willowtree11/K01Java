package ex06array;

public class E05TwoDimArray01 {

	public static void main(String[] args) {
		
		/*
		 아래와 같이 2차원 배열을 초기화하면 세로3, 가로 4인 배열이 생성된다
		초기화 할 요소가 없는 부분은 null로 채워지게 된다.
		※null값: 아무것도 없는 값을 일컫는다. 즉 빈 값
		스페이스는 '공백문자'가 존재하므로 이와 다르다.
		  
		 */
		int[][] arr= {
				{1,2}, //null 2개
				{3,4,5}, //null 1개
				{6,7,8,9}
		};
		
		/*
		 
		 2차원 배열에서 "배열명.length"로 출력하면 세로크기가 반환됨. 
		  
		 */
		System.out.println("배열의 세로크기: "+arr.length);
		System.out.println("배열명이 가진 값 출력(arr): "+arr); //주소값 출력
		
		/*
		 
		 각 행의 가로크기는 초기화된 상태에 따라 다를 수 있다.
		 0행은 2, 2행은 4의 크기를 가지게 된다.
		 
		 */
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%d행의크기:%d\n", i, arr[i].length);
			System.out.printf("%d행 출력:%s\n", i, arr[i]);
		}
		
		System.out.println("배열 출력하기");
		System.out.println("arr[0][1]= "+arr[0][1]);//정상출력
		//System.out.println("arr[0][3]= "+arr[0][3]);//예외발생(초기화 되지 않은 공간;null값 은 선언한 배열 크기를 벗어남)Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
		//System.out.println("arr[3][4]= "+arr[0][3]);//예외발생 선언한 배열 크기를 벗어남
		/*
		 
		 [예외발생] ArrayIndexOutOfBoundsException
		  즉, 배열의 index를 초과했다는 뜻
		  
		 */
	}

}
