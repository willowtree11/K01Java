package ex20io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class E08StringWriter {

	public static void main(String[] args) {
		try {
			/*
			 문자열을 저장하기 위한 출력스트림을 생성한다.
			 문자열의 입력은 버퍼에 따라 성능의 차이가 크기 때문에
			 버퍼 필터스트림을 추가적으로 연결해 사용한다.
			 */
			BufferedWriter out =new BufferedWriter(
						new FileWriter("src/ex20io/string.txt")
					);
			
			/*
			 write()를 통해 문자열을 저장하고, 줄바꿈은 newLine()통해 처리
			 개행(줄바꿈)은 newLine() 메소드를 통해 이루어진다.
			 \n을 사용하지 않는 이유는 OS 마다 표현방식이 다르기 때문이다. 
			 결국 호환성을 위함이다.
			 
			 */
			out.write("나는 KOSMO에서 공부한다.");
			out.newLine();
			out.write("수료 후 꼭 취업하겠다.");
			out.newLine();
			
			out.close();
			System.out.println("입력 완료");
					
		}
		catch (FileNotFoundException e) {
			System.out.println("파일없음");
		}
		catch (IOException e) {
			System.out.println("IO오류");
		}

	}

}
