package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 ◈ 직렬화란?
자바 시스템 내부에서 사용되는 객체 또는 데이터를 외부의 자바 시스템에서도 사용할 수 있도록
바이트(byte) 형태로 데이터를 변환하여 파일에 저장되는 과정을 말한다.
파일에서 복원하는 것은 ‘역직렬화’라 한다. 

직렬화의 대상이 되는 인스턴스의 클래스는 java.io.Seiralizable 인터페이스를 구현해야 한다. 
이 인터페이스는 ‘직렬화의 대상임을 표시’하는 기능을 가진다. 

=====

Circle클래스를 입출력의 대상으로 파일 저장하기 위해 Serializable 인터페이스를 구현하여 정의
인스턴스가 파일의 형태로 저장되는 것이 직렬화
상속이 되는 경우, 부모쪽만 구현하면 됨.

 */


class Circle implements Serializable{
	int xPos, yPos;
	double radian;
	public Circle(int x, int y, double r) {
		xPos =x;
		yPos =y;
		radian =r;
	}
	public void showCircleInfo() {
		System.out.printf("좌표[%d, %d]", xPos, yPos);
		System.out.println("반지름: "+radian);
		
	}
}

//여러개 다른 객체가 저장되려면 부모급이 되어야 하므로 Object에 저장
public class E11ObjectSerializable {

	public static void main(String[] args) {
		
		try {
			//인스턴스를 파일에 저장하기 위한 스트림을 생성
			ObjectOutputStream out=
					new ObjectOutputStream(
							new FileOutputStream("src/ex20io/circle.obj"));
			
			//인스턴스를 파일에 저장한다.
			out.writeObject(new Circle(1, 1, 2.4));
			out.writeObject(new Circle(2, 2, 4.8));
			out.writeObject(new String("String 타입의 오브젝트")); /*
				Java에서 제공하는 기본클래스는 별도의 처리 없이 직렬화가 가능하다.
			*/
			out.close();
			
			/*
			 인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고
			 readObject()를 통해 복원
			 */
			
			ObjectInputStream in=
					new ObjectInputStream(
							new FileInputStream("src/ex20io/circle.obj"));
						
			//저장된 순서대로 인스턴스를 복원한다.
			Circle c1=(Circle)in.readObject();
			Circle c2=(Circle)in.readObject();
			String message=(String)in.readObject();
			in.close();
			
			//복원된 객체의 확인을 위해 정보를 출력한다.
			c1.showCircleInfo();
			c2.showCircleInfo();
			System.out.println("String 오브젝트: "+message);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("클래스 없음");
		}
		catch (FileNotFoundException e) {
			System.out.println("파일 없음");
		}
		catch (IOException e) {
			System.out.println("뭔가 없음");
		}
	}

}
