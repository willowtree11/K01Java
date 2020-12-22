package ex09package.kosmo.perimeter;

public class Circle {
	double rad;
	final double PI;
	
	public Circle(double rad) {
		this.rad=rad;
		PI=3.14159;
	}
	//원의 둘레 계산 메소드
	public double getPerimeter() {
		return 2*PI*rad;
	}

	
}
