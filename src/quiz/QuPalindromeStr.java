package quiz;

import java.util.Scanner;

/*
문제) 파일명 : QuPalindromeStr.java
회문(palindrome)은 순서를 거꾸로 읽어도 제대로 읽은 것과 같은 단어와 문장을 뜻한다. 예를
들면 "level", "SOS", "rotator"와 같은 단어가 있다. 사용자로 부터 입력받은 단어가 회문인지
판단하는 프로그램을 작성하시오.
실행결과] 아래는 2회 실행한 결과입니다.
회문인지 판단할 단어를 입력해주세요:asdfdsa
입력하신 단어는 회문입니다.
회문인지 판단할 단어를 입력해주세요:student
입력하신 단어는 회문이 아닙니다. 
*/
public class QuPalindromeStr {
	
	public static void main(String[] args) {
		
		System.out.print("회문인지 판단할 단어를 입력해주세요: ");	
		
		Scanner scanner=new Scanner(System.in);
		String word=scanner.nextLine(); //입력받을 문자
		
		boolean palCheck=true;
		char[] arr=new char[100000];
		arr=word.toCharArray(); //Converts this string to a new character array.
		for(int i=0; i<word.length()/2; i++) { //입력받은 단어 철자의 반절까지 카운팅			
			
			if(arr[i]==arr[word.length()-i-1]) { //저장된  문자열 배열 반개만큼이-다른 반만큼의 배열과 일치하면
				palCheck=true;
				System.out.println("입력하신 단어는 회문입니다.");
				return;
			}
			else {
				palCheck=false;
				System.out.println("입력하신 단어는 회문이 아닙니다.");
				break;
			}
		}	
       
	}
	
}

