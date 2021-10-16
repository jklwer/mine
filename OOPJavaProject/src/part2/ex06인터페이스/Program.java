package part2.ex06인터페이스;

public class Program {

	public static void main(String[] args) {

		A a = new A();
		X x = new C();
		a.setX(x);
		a.print();
		
//		B b = new B();
//		
//		a.setX(b);	//B클래스에서 X 인터페이스를 implements해야 동작 

	}

}
