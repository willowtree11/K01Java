package quiz;

import java.util.Scanner;

public class QuTicTacToe {

	public static void main(String[] args) {
		char[][] tttgame = new char[3][3]; //게임보드
		int x, y;
		
		Scanner scan  = new Scanner(System.in);
		
		// 배열 초기화
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				tttgame[i][j] = ' ';
			}
		System.out.print("좌표를 입력하세요: ");
			x = scan.nextInt();
			y = scan.nextInt();
		
		//이하 못 푼 로직
		//게임보드에 기입할 좌표를 입력받는다
		//좌표를 해당되는 위치에 찍는다
		//위 작업을 번갈아 한다(user가 2명으로 나뉘어 있어야 한다.)
		//가로, 세로, 대각선 경우의 수(6가지)에 해당되는 user에게 승리 판정을 한다
		//승리판정이 된 user 외의 user에게 패배 판정을 한다

	}

}
