package quiz;

import java.util.Random;
/*
 정렬알고리즘 - 버블정렬(Bubble Sort) :
 중첩 for문, 배열 사용하기
 
1. 중복되지 않는 난수 10개(1~99)를 생성하여 크기가 10인 배열에 담는다.
2. 오름차순으로 버블정렬한다.(1, 2, 3 …… 10)
3. 버블정렬이란 모든 배열요소를 순차적으로 비교하여 스왑(교환)하는 알고리즘이다.
4. 단, 정렬되는 과정을 모두 출력해야 한다.
5. 위 그림은 버블정렬을 이용하여 오름차순으로 정렬하는 과정이다.

 */
public class Bubble {

	public static void main(String[] args) {
		
		int[] arrNum= new int[10];
		for(int i=0; i<arrNum.length; i++) {
			arrNum[i]=(int)((Math.random()*100)%99)+1; //난수 생성 후 배열저장
			System.out.print("생성된 난수 초기값: "+arrNum[i]+", ");
			
			int j=0;
			for(j=i; j<arrNum.length; j++) {
				if(arrNum[j]>arrNum[j+1]) { //앞 숫자가 뒷 숫자보다 크면
					int temp = arrNum[j]; // 임시 변수에 저장
					arrNum[j] = arrNum[j+1]; //앞 숫자를 뒤로 보낸다
					arrNum[j+1] = temp; //뒷 숫자는 앞으로 보낸다
				}
				else {
					return;
				}
			}
			System.out.print("버블정렬 후 배열 출력: "+arrNum[j]);
		}
		
	}

}
