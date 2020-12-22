package ex10accessmodifier;


/*
 
 프로그램을 아래 조건에 맞춰서 수정하시오.
윈도우 기본프로그램인 그림판은 좌상단이 0,0 이고 우하단으로 갈수록 좌표값이 커진다.
멤버변수가 정보은닉이 되지않아 멤버변수에 직접 접근이 가능하고, 잘못된 값을 입력할 소지가 있다.
멤버변수의 직접접근을 차단하고, 생성자 메소드를 이용하여 멤버변수를 초기화할수 있도록 한다.
x, y 좌표는 0 ~ 100 사이의 값을 가진다. 즉 좌표값이 마이너스 or 100을 초과하면 ‘좌표 범위가 잘못되었다’라고 print해줘야 한다.
우하단의 좌표값이 좌상단의 좌표값보다 작아서는 안된다. 이 경우 ‘좌표 지정이 잘못되었다’ 라고 print해줘야 한다.
좌표R값이 정상일때만 넓이가 출력된다.

힌트 :점 두개로 사각형을 나타낼 수 있음, 그림판

  
 */
class Rectangle
{
	//멤버변수
   	private int ulx, uly;//좌상단(upper left x, upper left y)
   	private int lrx, lry;//우하단(lower right x, lower right y)
   	private boolean isTrue=true; //좌표값의 정상여부를 판단하기 위한 멤버변수 추가
   	
	/* 디폴트(기본) 생성자는 개발자가 생성자를 정의하지 않았을 때만 자동으로 생성된다
	 * public Rectangle() {
	 * 
	 * }
	 */
   	
   	//생성자
   	public Rectangle(int ulx, int uly, int lrx, int lry) {
   		
   		/* 
		좌표값이 정상범위안에 있는지 판단하여 초기화한다.
		*/
   		
   		if(isRange(ulx)==false || isRange(uly)==false) {
   			System.out.println("좌측 상단의 좌표 범위가 잘못되었습니다.");
   			isTrue=false;
   		}
   		if(isRange(lrx)==false || isRange(lry)==false) {
   			System.out.println("우측 하단의 좌표 범위가 잘못되었습니다.");
   			isTrue=false;
   		}
   		//좌 - 우측 좌표가 뒤바뀐 경우를 오류로 처리하기 위한 식
   		if(ulx>=lrx || uly>=lry) {
   			System.out.println("좌/우측 좌표 지정이 잘못되었습니다.");
   			isTrue=false;
   		}
   		
   		//멤버변수 초기화
   		this.ulx=ulx;
   		this.uly=uly;
   		this.lrx=lrx;
   		this.lry=lry;	   		
   			
   	}
   	// 매개변수로 전달된 좌표값이 정상범위안에 있는지를 판단
   	public boolean isRange(int point) {
   		if(point < 0 || point > 100) {
   			return false;
   		}
   		else {
   			return true;
   		}
   	}
   	public void showArea()
   	{
   		if(isTrue==false) {
   			System.out.println("좌표값 오류로 넓이를 계산할수 없습니다.");
   			return;   			
   		}   		
   		// 좌표값을 통해 가로/세로 길이를 구한 후 넓이 계산   		
   		int xLength = lrx - ulx;
   		int yLength = lry - uly;
   		System.out.println("사각형의 넓이: "+(xLength*yLength));   		
   	}  	
}

public class QuRectangle {
   	public static void main(String[] args)
   	{	   		
		/*여기부터		   			
     		Rectangle rec = new Rectangle();
     		rec.ulx=22;
     		rec.uly=22;
     		rec.lrx=10;
     		rec.lry=10;
		여기까지는 정보은닉후 실행되지 않게 해야한다....*/

		//아래 생성자로만 객체생성후 초기화 되도록 처리한다...
		Rectangle rec1 = new Rectangle(1,1,10,10);
		rec1.showArea();
		
		Rectangle rec2 = new Rectangle(-2,-2,101,101);
		rec2.showArea();
		
		Rectangle rec3 = new Rectangle(10,10,1,1);
		rec3.showArea();
   	}
}
