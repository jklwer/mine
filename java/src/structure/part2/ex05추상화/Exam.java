package structure.part2.ex05추상화;

public abstract class Exam {
	private int kor;
	private int eng;
	private int math;

	
	public Exam() {
		this(0, 0, 0);
	}

	//오버로드 생성자 만들면 기본생성자도 하나 만들어주기 
	public Exam(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public abstract int total();
	
	//protected : 자식에게 공개 
	protected int onTotal() {
		return kor + eng + math;
	}

	public abstract float avg();
	
	
}
