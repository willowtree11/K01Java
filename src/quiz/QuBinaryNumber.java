package quiz;

import java.util.Scanner;

public class QuBinaryNumber {
	
	public static void main(String[] args) {
		
		System.out.print("2진수로 변환할 정수를 입력하세요: ");	
		
		Scanner scanner=new Scanner(System.in);
		
		int[] arr = new int[100]; //배열선언
		int n=scanner.nextInt();
		
		int count= 0; //변수초기화
		
		for (int i = 0; n > 0; i++) {
			arr[i] = n % 2;//나머지
			n = n / 2;//연산을 위한 10진수 /2반복
			count++;
		}
		System.out.print("실행결과: ");
		for (int j = count-1; j >=0 ; j--) {
			System.out.print(arr[j]);
		}		
 	}
}
