package ex05method;

import java.util.Scanner;

public class E05MethodType04_2 {
//난이도 높음..
	
	public static void main(String[] args) {
		
		int maxValue1 = returnMaxNumber(4);
		System.out.println("최대값1: "+maxValue1);
		
		int maxValue2 = returnMaxNumber(6);
		System.out.println("최대값2: "+maxValue2);
	}
	
	static int returnMaxNumber(int numberCnt) {
		Scanner scanner = new Scanner(System.in);
		
		int maxVal=0; 
		for(int i=1; i<=numberCnt; i++) {
			System.out.print("정수를 입력하세요:");
			int inputNum = scanner.nextInt();
			
			if(i==1) {
				//입력 받은 숫자 중 첫번째 입력값을 기준값으로 설정한다.
				//0보다 작은 음수인경우 계속 0이 나오게 되므로 최대값 기준은 입력된 수로 두어야함
				maxVal=inputNum;
			}
			else {
				if(maxVal<inputNum) {//두번째 입력값부터는 maxVal과 비교한다. (처음을 거쳐야 비교대상이 생김)
					//만약 maxVal 보다 입력값이 크다면 입력값으로 교체한다
					maxVal=inputNum; 
				}
				//maxVal이 더 크다면 기존값을 유지하면 되므로 else부분은 필요없음
			}
		}
		
		return maxVal;
	}//end of returnMaxNumber
}
