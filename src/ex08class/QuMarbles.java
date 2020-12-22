package ex08class;
/*

문제3) QuMarbles.java (난이도:상)
구슬치기 하는 아이들을 추상화하여 클래스로 정의해보자.
*어린아이가 보유하고 있는 구슬의 개수 정보를 담는다 =>멤버변수
*놀이를 통해 구슬을 획득 또는 상실하는 것을 표현한다. => 멤버메소드
*어린이의 현재 보유하고 있는 구슬의 개수를 표현한다. => 멤버메소드

초기화는 다음과 같이 진행한다.
◆어린이1의 보유갯수 : 구슬 20개
◆어린이2의 보유갯수 : 구슬 15개

게임은 다음과 같이 진행한다.
◆1차게임 : 어린이1은 어린이2의 구슬 5개를 획득한다.
◆2차게임 : 어린이2는 어린이1의 구슬 9개를 획득한다.

# 어린이 객체를 생성시 구슬의 보유갯수는 생성자를 통해 초기화 되어야 한다.
 
*/

class ChildProperty{
	//1. 멤버변수	어린아이가 보유하고 있는 구슬의 개수 정보를 담는다
	int beadCnt; //아이가 가진 구슬갯수
	
	//2. 생성자 : 클래스와 이름이 같음, 반환타입이 없음, public만 붙임
	public ChildProperty(int beadCnt) {
		//super(); 상속관련문 추후에 배우자
		this.beadCnt = beadCnt;
	}
	
	//3_1. 멤버메소드: 반환타입 있어야함, 어린이가 보유한 구슬의 갯수를 출력
	public void showProperty() {
		System.out.println("보유 구슬의 갯수: "+beadCnt);
	}
	
	//3_2. 멤버메소드: 구슬치기 게임을 표현 (어떤 아이?, 딴 구슬 갯수?)
	public void obtainBead(ChildProperty child, int bCnt){
		//게임에 승리한 어린이(해당 메소드를 호출한 주체인 객체)
		this.beadCnt += bCnt;	
		
		//게임에 패배한 어린이(해당 메소드가 호출되었을 시 매개변수로 전달된 객체)
		child.beadCnt -=bCnt;
	}	
}

public class QuMarbles {
	
	public static void main(String[] args) {
		
		//생성자를 통해 만들어짐, 인자1개
		ChildProperty child1 = new ChildProperty(20);
		ChildProperty child2 = new ChildProperty(15);
	
		System.out.println("게임 전 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty(); 
	
		/*1차게임 : 어린이1은 어린이2의 구슬 5개 획득*/
		child1.obtainBead(child2, 5);
	
		/*2차게임 : 어린이2가 어린이1의 구슬 9개 획득*/
		child2.obtainBead(child1, 9);
	
		System.out.println("\n게임 후 구슬의 보유 개수");
		System.out.print("어린이1 : ");
		child1.showProperty(); 
		System.out.print("어린이2 : ");
		child2.showProperty();
	
		}
}

