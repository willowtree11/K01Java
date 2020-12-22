package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 ▣ transient : 직렬화의 대상에서 제외할때
transient로 선언된 멤버는 직렬화의 대상에서 제외된다. 
복원시 null, 0, 0.0이 대신 저장된다. 

ex. 패스워드같은 민감정보 감출 때
 */

class PersonalInfo implements Serializable
{
	String name;
	transient String myWeight;
	int age;
	transient int mySecretNumber;
	
	public PersonalInfo(String n, String mw, int a, int msn) {
		name =n;
		myWeight=mw;
		age=a;
		mySecretNumber=msn;
		
	}
	
	public void showInfo() {
		System.out.printf("이름: %s%n", name);
		System.out.printf("몸무게: %s%n", myWeight);
		System.out.printf("나이: %s%n", age);
		System.out.printf("금고번호: %s%n", mySecretNumber);
	}
}

public class E12TransientMembers {

	public static void main(String[] args) {
		
		try {
			
			ObjectOutputStream out=
					new ObjectOutputStream(
							new FileOutputStream("src/ex20io/prson.obj")
							);
			PersonalInfo info=new PersonalInfo("김깜빡", "120kg", 33, 1234567890);
			
			System.out.println("인스턴스 생성직후 출력");
			info.showInfo();
			System.out.println("==============================================");
			out.writeObject(info);
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(
						new FileInputStream("src/ex20io/person.obj")
					);
			PersonalInfo reInfo=
					(PersonalInfo)in.readObject();
			in.close();
			
			System.out.println("인스턴스 복원 후 출력");
			reInfo.showInfo();
			
		} 
		catch (ClassNotFoundException e) {
		}
		catch (FileNotFoundException e) {
		}
		catch (IOException e) {
		}
		
		
	}

}
