package ex15usefulclass;

import java.util.Random;

public class E06Random {

	public static void main(String[] args) {
		
		/*
		 컴퓨터는 인자로 전달되는 seed(씨앗)을 기반으로 난수를 생성한다.
		 만약 seed값이 동일하다면 항상 동일한 패턴의 난수를 생성하게 된다.
		 이를 가짜난수(Pseudo-random number)라고 한다.
		 */
		
		System.out.println("### 난수생성1 : seed로 32를 사용");
		//seed가 같으면 항상 똑같은 난수만 생성됨..
		Random random1 = new Random(32);
		for (int i = 0; i < 10; i++) {
			/*
			 nextInt()의 인자값 100이 전달되면 0~99사이의 난수가 생성된다.
			 
			System.out.println(random1.nextInt(100));*/
		}	
		
		System.out.println("### 난수생성2 : seed 없음");
		Random random2 = new Random();
		for (int i = 0; i < 10; i++) {			
			System.out.println(random2.nextInt(100));
		}
		
		//가장 많이 사용되는 방법		
		//currentTimeMillis 현재 시간을 밀리 초 단위로 반환하는 메소드
		//setSeed random클래스를 통해 난수를 생성할 때 seed를 설정하기 위한 메소드
		//위에 표기한 메소드가 함께 쓰는 경우 '현재 시간'에 '시드를 맞추겠다'는 뜻-> 시시각각 바뀜
		System.out.println("### 난수생성3 : 항상 다른 seed를 사용");
		Random random3 = new Random();
		 
		System.out.println(System.currentTimeMillis());
		random3.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 10; i++) {			
			System.out.println(random3.nextInt(100));
		}
		
		System.out.println("### 난수생성4 : 항상 다른 seed를 사용, nextInt() 인자없음");
		Random random4 = new Random();		
		
		random4.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 10; i++) {			
			/*
			 nextInt()에 인자값이 없는 경우에는 음수, 양수가 혼용되어 난수가 생성된다.
			 또한 범위가 없기 때문에 몇자리가 생성될지 알 수 없다.
			 */
			System.out.println(random4.nextInt());
		}
	}


}
