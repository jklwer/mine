package part2.ex05추상화;

import structure.part2.ex05추상화.ExamConsole;

public class Program {

	public static void main(String[] args) {
		//NewlecExam exam = new NewlecExam();
		ExamConsole console = new NewlecExamConsole();
		console.input();
		console.print();
	}

}
