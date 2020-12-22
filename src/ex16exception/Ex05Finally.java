package ex16exception;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 finally 절
 : 	예외발생 여부와 상관 없이 try문에 진입했을 때 반드시 실행해야 할 코드가 있는 경우 기술하는 블럭
	즉 try문으로 진입되지 않는다면 finally 절은 실행되지 않는다.
 1) try~catch : 예외를 직접 처리할 때
 2) try~catch~finally : 예외를 직접 처리 후 실행할 문장이 있을 때
 3) try~finally : 예외는 외부로 던지고 예외발생과 상관없이 실행할 문장이 있을 때
 */
public class Ex05Finally {

	//런타임 예외가 발생되는 메소드
	static void runtime() throws NumberFormatException{
		Integer.parseInt("백");
	}
	
	static void tryCatchFinally() {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("나이를 입력하세요: ");
		int age=-1; //기존 Integer.MAX_VALUE 별 의미 없어서 -1(한국나이)로 대체
		try {
			age=scan.nextInt(); //<-'30살' 입력
			System.out.println("당신은 5년 후 "+(age+5)+"살 입니다.");
			return;//try구문에서 return을 만나도(정확하게 숫자만 기입해서 문제없이 실행되는 경우)
			//finally는 무조건 실행됨.
			
		}
		catch(InputMismatchException e) {
			//예외가 발생되더라도 finally 구문은 실행된다.
			System.out.println("나이는 숫자만 쓰세요");
		}
		finally {
			System.out.println("항상 실행되는 finally 절입니다. ");
			
			//exit(0)가 try문에 있는 경우 바로 종료되므로 finally 구문은 실행이 안된다. 
			System.exit(0); //프로그램 자체가 종료된다.
			}		
	}
	
	public static void main(String[] args) {
		try {
			runtime();
			
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		tryCatchFinally();
		System.out.println("메인 메소드 끝");
	}
}
