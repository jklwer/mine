package part2.ex06인터페이스;

public class A {

	private X x;	//인터페이스 
	
	public void setX(X x) {
		this.x = x;
	}

	
	public A() {
		//x = new X(); 인터페이스는 생성 불가 
		
//		b = new B();
	}

	public void print() {
		//	B의 기능을 이용하여 total값을 출력하는 메소드
		int total = x.total();
		System.out.println("total is " + total);
	}
	
	
}
