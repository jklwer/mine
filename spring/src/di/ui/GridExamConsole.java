package di.ui;

import di.entity.Exam;

public class GridExamConsole implements ExamConsole {

	private Exam exam;
	
	
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}
	
	
	@Override
	public void print() {
		System.out.println("grid 방식의 출력입니다.");
		System.out.println("total is " + exam.total());
		System.out.println("avg is " + exam.avg());
	}

}
