package ex16exception;
/*

문제1) QuRockPaperScissorsException.java
가위바위보 게임에 다음 조건에 맞는 예외처리 구문을 추가하시오
숫자대신 문자를 입력할 경우 발생되는 예외를 처리하시오. (가위바위보 입력시, 재시작여부 입력시)
게임과 관련없는 숫자를 입력했을때 사용자정의 예외클래스를 통해 처리하시오.
예외처리 클래스명 : WrongNumberException

선생님 파일 기준 GameRockPaperScissorException 파일 참고

scanner.nextLine(); 예외처리시 엔터키(줄바꿈) 해서 무한루프에 빠지는것을 방지 - 버퍼에 남아있던 줄바꿈을 제거해줌

*/

import java.util.Random;
import java.util.Scanner;

class WrongNumberException extends Exception{
	public WrongNumberException() {
		super("[예외발생] 1~3 사이의 숫자를 입력하세요.");
	}
}

public class QuRockPaperScissorsException {

	public static void rpsGameStart() {
		Scanner scanner = new Scanner(System.in);
		Random random=new Random();
		int gameCount=0; //게임 카운트용 변수
		
		
		while(true) {
			//1. 난수생성 - 컴퓨터입장에서 가위/바위/보		
			int com = random.nextInt(10000) % 3 + 1; //나머지가 0,1,2 가 나오니 +1을 해준다. 1~3사이의 난수, nextInt()를 썼을때 음수도 나올 수 있으므로 %연산
			System.out.println("컴퓨터"+com);
			
			//2. 사용자 입력
			int user = 0;
			System.out.println("가위 바위 보를 입력하세요.");
			System.out.println("가위(1), 바위(2), 보(3) => ");
			user=scanner.nextInt();
			
			//3. 승부 판단
			if(!(user<1 || user>3)) { //정상적으로 1, 2, 3을 기입한 상황, (user<1 || user>3)는 범위 밖인데 이것의 not 조건이므로=올바른 상황
				
				System.out.printf("사용자:%s, 컴퓨터:%s ", displayRPS(user), displayRPS(com)); //가위바위보 출력용 함수를 이용해서 정보출력
				
				switch(user-com) {
				case 0:
					System.out.println("비겼습니다");break;
				case 1: case -2: //case 는 or조건 가능
					System.out.println("이겼습니다");break;
				case 2: case -1:
					System.out.println("졌습니다");break;
				}
				gameCount++; //게임 카운트 증가
			}		
			
			else {
				System.out.println("가위 바위 보 할 줄 몰라요?? 제대로 내세요!");
			}		
			
			int restart; 
			if(gameCount>=5) { 
				System.out.println("게임 재시작(1), 종료(0): ");
				restart=scanner.nextInt();
				
				if(restart==0) {
					//게임종료
					break; //while문을 탈출함
				}
				else {
					//게임 재시작
					gameCount=0; //게임카운트 0으로 초기화
					System.out.println("게임을 재시작 합니다.");
				}
				
			}
		}//// end of while	
	}////end of rpsGameStart()
	
	public static String displayRPS(int n) {
		String str="";
		switch(n) {
		case 1: str="가위";break;
		case 2: str="바위";break;
		case 3: str="보";break;
		}
		return str;
	}
	
	public static void main(String[] args) {
		rpsGameStart();
	}


}
