package structure.part2.ex04UI코드분리;

public class ExamList {
	private Exam[] exams;
	private int current;

	public Exam get(int i) {
		// TODO Auto-generated method stub
		return this.exams[i];
	}

	public void add(Exam exam) {

		Exam[] exams = this.exams;
		int size = this.current;

		if (exams.length == size) {
			// 배열의 총 길이와 현재 가리키는 값이 같을 때 = 배열에 남은 공간이 없을 때
			// 크기가 더 큰 새로운 배열을 생성
			Exam[] temp = new Exam[size + 5];
			// exams의 데이터를 temp로 옮기기 (값을 이주시키기)
			for (int i = 0; i < size; i++) {
				temp[i] = exams[i];
				// list.exams가 temp의 주소를 참조하도록
				this.exams = temp;

			}
		}

		this.exams[this.current] = exam;
		this.current++;

	}

	public ExamList() {

		this.exams = new Exam[3];
		this.current = 0;

	}

	public int size() {
		// TODO Auto-generated method stub
		return current;
	}
}

//this 지우기 추천
