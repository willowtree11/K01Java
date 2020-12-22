package ex05method;

import java.util.Scanner;

public class QuTemperature {
	//섭씨->화씨
	static double celsiusToFahrenheit(int cel) {
		return 1.8*cel+32;
	}
	
	//화씨->섭씨
	static double fahrenheitToCelsius(int fah) {
		return (fah-32) / 1.8;
	}
	
	public static void main(String[] args) {
		System.out.println("'섭씨 20도->화씨: ");
		System.out.println(celsiusToFahrenheit(20));
		
		System.out.println("'화씨 98도->화씨: ");
		System.out.println(fahrenheitToCelsius(98));
	
	}
//내가 한 것	
//	static void fahren(double seop) {
//		
//		double fOndo=1.8 * seop + 32;
//		System.out.println("변환 완료(화씨): "+fOndo+"F˚");
//	}
//	
//	static void cels(double hwa) {
//		
//		double cOndo=(hwa-32)/1.8;
//		System.out.println("변환 완료(섭씨): "+cOndo+"C˚");
//		return;
//	}
//	
//	public static void main(String[] args) {
//		
//		Scanner scanner = new Scanner(System.in);	
//		System.out.println("화씨 온도로 변환할 섭씨 온도를 입력하세요: ");
//		double seop= scanner.nextInt();
//		fahren(seop);
//		
//		System.out.println("섭씨 온도로 변환할 화씨 온도를 입력하세요: ");
//		double hwa= scanner.nextInt();
//		cels(hwa);
//	}


}
