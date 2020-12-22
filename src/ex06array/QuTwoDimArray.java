package ex06array;

public class QuTwoDimArray {
/*
 
이 메소드는 배열에 저장된 값을 add 만큼 증가시킨다.
이 메소드를 기반으로 int형 2차원 배열에 저장된 값을 증가시키는 프로그램을 작성하시오.
단 2차원 배열의 가로, 세로길이에 상관없이 동작해야 하고, 반드시 addOneArr() 메소드를 사용하여 구현해야 한다. 
그리고 증가되기전의 값과 증가되고 난 후의 값을 모두 출력해야 한다.
구현할 프로그램의 포맷은 다음과 같다. 
 
*/
	
	//문제에서 제시한 내용
	public static void addOneArr(int[] arr, int add)
	{
		//가로에 대한 반복
		for(int i=0; i<arr.length; i++){	
			arr[i] += add;
		}
	}
	//addOneArr() 메소드를 기반으로 2차원 배열을 증가시키는 메소드
	public static void addTwoArr(int[][] arr, int add)
	{
		//세로에 대한 반복을 통해 한 행씩 addOneArr()로 전달한다
		//이차원 배열에서는 배열의 이름을 통해 세로길이를 알 수 있음
		for(int i=0; i<arr.length; i++) {
			addOneArr(arr[i], add); //한 행씩 선택하여 int[] arr에 전달
			for(int j=0; j<arr[i].length; j++) {
				
				arr[i][j] += add;
			}
		}
	}
	
	public static void main(String[] args){		
		//배열선언 : 비어있는 부분은 null로 초기화 됨
		int[][] arr = {
			{1, 2, 3, 4},
			{5, 6, 7},
			{8, 9}
		}; //arr [1][1] = 6, arr [1]=은 5,6,7이 있는 2번째 행
		//값 증가전 출력
		arrPrint(arr);
		
		//2만큼 증가시키는 메소드 호출
		addTwoArr(arr, 2);
		
		//증가후 출력
		arrPrint(arr);
	}
	
	//2차원 배열을 출력하기 위한 메소드
	static void arrPrint(int[][] arr) {
		
		//세로 크기만큼 반복
		for(int i=0; i<arr.length; i++) {
			
			//가로 크기만큼 반복
			for(int j=0; j<arr[i].length; j++) {
				//각각의 요소를 출력함
				System.out.printf("%-5d",arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}