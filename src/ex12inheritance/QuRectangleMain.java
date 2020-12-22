package ex12inheritance;
/*
 
 문제3) QuRectangleMain.java
정사각형을 의미하는 Square클래스와 직사각형을 의미하는 Rectangle클래스를 정의하고자 한다.
그런데 정사각형은 직사각형의 일종이므로, 다음의 형태로 클래스의 상속관계를 구성하고자 한다. 아래의 소스를 참조하여 구현하시오. 
실행결과]
직사각형 면적: 12
정사각형 면적: 49
 
 */

//직사각형을 표현한 클래스
class Rectangle
{		
	public static int rec=0;
    
	//멤버변수
	int wid;
    int hei;
    
    public Rectangle(int wid, int hei) {
    	this.wid=wid;
    	this.hei=hei;
    	Rectangle.rec=wid*hei;
    }
    public void ShowAreaInfo() { //사각형 넓이 출력
    	System.out.println("직사각형 면적: "+Rectangle.rec);
    }
} 
//정사각형을 표현한 클래스(정사각형은 직사각형의 일종)
class Square extends Rectangle{	
	
	public static int sq=0;
	
	/*
	 생성자: 
	*/
	public Square(int wid){
		super(wid, wid);
		this.wid=wid;
		Square.sq = wid*wid;
	}
	//공식은 동일하나 직사각형, 정사각형의 면적 출력해야 하므로 오버라이딩 처리
	@Override
	public void ShowAreaInfo() {
		System.out.println("정사각형 면적: "+Square.sq);
	}
} 
class QuRectangleMain
{
	public static void main(String[] args)
	{
     	Rectangle rec = new Rectangle(4, 3);
     	rec.ShowAreaInfo();

     	Square sqr = new Square(7);
     	sqr.ShowAreaInfo();
 	}
}