package ex03operator;

public class E07BitOperator {

	public static void main(String[] args) {
		
		int num1 = 5; // 2진수 00000000 00000000 00000000 00000101
		int num2 = 3; // 2진수 00000000 00000000 00000000 00000011
		int num3 = -1; // 2진수 11111111 11111111 11111111 11111111 
					   //( 1+(-1)=0 을 이용해 00000000 00000000 00000000 00000001 더하면 0이 되는것을 확인)
		//int는 4바이트 00000000 00000000 00000000 00000000
		/*
		 -1이 위와 같이 되는 이유는 1을 더했을 때 0이 되기 때문
		 양의 정수 1에 2의 보수를 취하면 -1이 된다 
		 */
		System.out.println("비트AND: "+(num1 & num2)); //2진수 00000001 => 1
		System.out.println("비트OR: "+(num1 | num2)); //2진수 0000111 => 7
		System.out.println("비트XOR: "+(num1 ^ num2)); //(*XOR연산 똑같으면0 다르면 1) 2진수 00000110 => 6 
		System.out.println("비트Not: "+(~ num3)); //
		/*
		 보수
		 0011 -> 1100 반전, 마이너스값
		 
		 */
	}

}
