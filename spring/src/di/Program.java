package di;

import di.entity.Exam;
import di.entity.NewlecExam;
import di.ui.ExamConsole;
import di.ui.GridExamConsole;
import di.ui.InlineExamConsole;

public class Program {

	public static void main(String[] args) {

		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole(exam);	//di
		//ExamConsole console = new GridExamConsole(exam);
	
		console.print();
	}

}
