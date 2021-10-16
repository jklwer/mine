package part2.ex05추상화;

import java.util.Scanner;

import structure.part2.ex05추상화.Exam;
import structure.part2.ex05추상화.ExamConsole;

public class NewlecExamConsole extends ExamConsole{

	@Override
	protected Exam makeExam() {
		// TODO Auto-generated method stub
		return new NewlecExam();
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		super.input();
	}
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		super.print();
	}

	@Override
	protected void onInput(Exam exam) {
		Scanner sc = new Scanner(System.in);
		NewlecExam newlecExam = (NewlecExam) exam;
		int com;
		
		do {
			System.out.print("컴퓨터 점수를 입력하세요 : ");
			com = sc.nextInt();
			if(com > 100 || com < 0) {
				System.out.println("잘못된 값의 범위");
			}
		} while (com > 100 || com < 0);		

		newlecExam.setCom(com);
		
	}

	@Override
	protected void onPrint(Exam exam) {
		NewlecExam newlecExam = (NewlecExam) exam;
		int com = newlecExam.getCom();
		System.out.println("컴퓨터 점수입니다 : " + com);
		
	}


}
