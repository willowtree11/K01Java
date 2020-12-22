package ex08class;

class Triangle{
	int b, h; //멤버변수(밑변, 높이)
	public void init(int b, int _h) {
		this.b=b; //멤버변수, 매개변수 구분을 위해 this를 써야함
		h=_h; //언더바_ 를 쓰는것도 일반적임			
	}
	public double getArea() { //반환값 있음, 삼각형의 넓이 구하는 메소드
		return (b*h)/2;
	}
	
	public void setBottom(int b) { //밑변을 설정
		this.b=b;
	}
	public void setHeight(int h) { //높이를 설정
		this.h=h;
	}
	
}
	
public class QuTriangle {	
	public static void main(String[] args) {
		Triangle t = new Triangle();
		t.init(10, 17); //밑변10, 높이17로 초기화
		System.out.println("삼각형의 넓이 : " + t.getArea());
		t.setBottom(50);//밑변 50으로 변경
		t.setHeight(14);//높이 14로 변경
		System.out.println("삼각형의 넓이 : " + t.getArea());
	}
}