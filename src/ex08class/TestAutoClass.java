package ex08class;

public class TestAutoClass {
	
	//멤버변수
	String carName;
	int carYear;
	String owner;
	
	/*
	 
	  이하 마우스 우클릭 Source-Generate -- 로 만들어진 코드들
	  생성자와 getter setter를 자동생성한 것
	  
	 */
	public TestAutoClass(String carName, int carYear, String owner) {
		super();
		this.carName = carName;
		this.carYear = carYear;
		this.owner = owner;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getCarYear() {
		return carYear;
	}

	public void setCarYear(int carYear) {
		this.carYear = carYear;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
}
