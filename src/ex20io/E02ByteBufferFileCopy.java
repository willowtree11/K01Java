package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/*
 1byte씩 읽어서 저장하는 것 보다 1024byte씩 읽을 수 있는 버퍼(buffer)를 이용하므로 복사속도 향상
 스트림 혹은 네트워크를 통해 파일을 전송할 때 버퍼를 사용하는 이유는 이러한 속도차이 때문.
 */
public class E02ByteBufferFileCopy {
	
	public static void main(String[] args) {
		
		try {
			InputStream in=new FileInputStream("src/ex20io/BANDIZIP6.EXE");
			OutputStream out= new FileOutputStream("src/ex20io/BANDIZIP6_copy2.EXE");
			
			int copyByte=0;
			int readLen;
			
			/*
			 1Kbyte씩 읽어서 저장하기 위한 버퍼 생성(1KB 용량의 버퍼 손수레를 생성)
			 */
			byte buffer[]=new byte[1024];
			
			while(true) {
				//1Kbyte씩 파일을 읽어옴
				readLen = in.read(buffer);
				if(readLen==-1) {
					break;
				}
				//읽어온 내용을 파일에 입력. 버퍼에 저장된 데이터를 인덱스 0의 위치에서 readLen의 크기만큼 전송
				out.write(buffer, 0, readLen);
				copyByte += readLen;
			}
			if(in!=null) in.close();
			if(out!=null) out.close();
			
			System.out.println("복사된 파일크기: "+ copyByte+"byte");
			System.out.println("복사된 파일크기: "+ (copyByte/1024) +"Kbyte");
			System.out.println("복사된 파일크기: "+ (copyByte/(1024*1024))+"Mbyte");
		} 
		catch (FileNotFoundException e) {
			
			System.out.println("파일이 없습니다.");
			
		}
		catch(IOException e) {
			System.out.println("IO작업 중 예외가 발생되었습니다.");
		}
		catch (Exception e) {
			System.out.println("알 수 없는 오류 발생됨.");
		}
	}
}
