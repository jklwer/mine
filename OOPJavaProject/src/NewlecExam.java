import structure.part2.ex04UI코드분리.Exam;

public class NewlecExam extends Exam{
	
	private int com;

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}
	
	@Override
	public int total() {
		return super.total() + com;
	}
	
	@Override
	public float avg() {
		return total()/4.0F;
	}
	
}
