package ex04controlstatement;

import java.io.IOException;
import java.util.Scanner;

public class Qu_04_02 {

	/*
	 하나의 문자를 입력받아 숫자인지 여부를 판단하는 프로그램을 
	 삼항연산자를 이용하여 구현하시오. (System.in.read()를 사용하세요)
	 */
	
	public static void main(String[] args)  throws IOException{
		
		//내가 썼던 코드 Scanner scanner = new Scanner(System.in);	
		System.out.print("하나의 문자를 입력하세요 : ");
		int asciiCode = System.in.read();
		
		String numberResult = (asciiCode>=48 && asciiCode<=57) ? "숫자입니다" : "숫자가 아닙니다" ;
		System.out.println(numberResult);
	}


}