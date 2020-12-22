package ex12inheritance;
//중심좌표(x,y)와 반지름이 필요
//상속이 아닌 종속(포함) Has-A 사용
/*
 
 문제4) QuRingMake.java
다음 Point클래스를 이용하여 다음 문제를 해결하시오. 
해당 문제는 상속을 통해 구현하는것이 아니라 구성관계를 이용하여 해결한다. 
Point 클래스를 기반으로 원을 의미하는 Circle클래스를 정의하자. 
그리고 Circle클래스를 기반으로 Ring클래스를 정의하자.
 실행결과]
안쪽원의 정보 :
반지름 : 3	
[x좌표:1, y좌표1]
바깥쪽원의 정보 :
반지름 : 9
[x좌표:2, y좌표2]

 */


class Point
{
   	int xDot, yDot;
   	public Point(int x, int y)
   	{
 		xDot=x;
 		yDot=y;
   	}
   	public void showPointInfo()
   	{
 		System.out.println("[x좌표:"+xDot+", y좌표"+yDot+"]");
   	}
}

//Point클래스를 기반으로 원(Circle) 클래스 표현하기
class Circle{	
	//멤버변수
	int radian;//반지름
	Point center;
	/*
	 
	  반지름을 표현하는 radian과 중심좌표를 표현한 Point객체 생성을 위해
	 총 3개(반지름, 포인트1, 포인트2)의 인자가 필요하다.
	  
	 */
	//생성자
	public Circle(int x, int y, int rad) {
		radian=rad;
		//멤버변수가 객체이므로 new를 이용해서 새로운 객체를 생성한다.
		center=new Point(x, y);
	}
	
	//정보출력용 멤버 메소드
	public void showCircleinfo() {
		//반지름과 중심좌표를 출력할 때, 중심좌표는 Point 클래스에 정의된 메소드를 호출한다
		System.out.println("반지름: "+radian);
		center.showPointInfo();
	}
}

//원 2개를 겹쳐서 링을 표현하는 클래스
class Ring{
	//멤버변수
	Circle innerCircle;//안쪽의 원
	Circle outerCircle;//바깥쪽의 원
	//생성자
	public Ring(int inX, int inY, int inRad, int outX, int outY, int outRad) {
		
		//멤버변수인 Circle 객체를 각각 초기화한다.
		innerCircle = new Circle(inX, inY, inRad);
		outerCircle = new Circle(outX, outY, outRad);		
	}
	
	//정보출력용 함수
	public void showRingInfo() {
		//각각의 객체가 상속관계가 아니므로 각 객체를 통해 멤버메소드를 호출해야 한다.
		System.out.println("안쪽 원: ");
		innerCircle.showCircleinfo();
		System.out.println("바깥쪽 원: ");
		outerCircle.showCircleinfo();
	}
}

class QuRingMake {
	public static void main(String[] args) {
		Ring c = new Ring(1,1,3,2,2,9);
		c.showRingInfo();
	}
}