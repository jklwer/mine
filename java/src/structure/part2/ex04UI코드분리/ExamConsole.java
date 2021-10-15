package structure.part2.ex04UI코드분리;

import java.util.Scanner;

public class ExamConsole {
	
	//캡슐이 다른 캡슐을 가지고 있는 상태 (Has a 관계)
	//ExamConsole이 ExamList를 가지고있고 부품으로 사용함 
	//Composition Has A 일체형 : ExamConsole가 만들어 질 떼 ExamList 생성 
	private ExamList list = new ExamList();
	//위 코드는 아래와 같다
	//private ExamList list;
	//public ExamConsole() {
	//	list = new ExamList();
	//}
	
	public void inputScores() {
		
		System.out.println(" -- 성적을 입력받겠습니다. -- ");

		Scanner sc = new Scanner(System.in);
		int kor, eng, math;
		
		do {
			System.out.print("국어 점수를 입력하세요 : ");
			kor = sc.nextInt();
			if(kor > 100 || kor < 0) {
				System.out.println("잘못된 값의 범위");
			}
		} while (kor > 100 || kor < 0);
		
		do {
			System.out.print("영어 점수를 입력하세요 : ");
			eng = sc.nextInt();
			if(eng > 100 || eng < 0) {
				System.out.println("잘못된 값의 범위");
			}
		} while (eng > 100 || eng < 0);
		
		
		do {
			System.out.print("수학 점수를 입력하세요 : ");
			math = sc.nextInt();
			if(math > 100 || math < 0) {
				System.out.println("잘못된 값의 범위");
			}
		} while (math > 100 || math < 0);
		
		Exam exam = new Exam(kor, eng, math);
//			Exam exam = new Exam();
//			
//			exam.setKor(kor);
//			exam.setEng(eng);
//			exam.setMath(math);
	
		list.add(exam);
	}

	

	public void printScores() {
		this.printScores(list.size());
		//똑같은 기능의 함수를 두번 호출할 경우 코드집중화로 코드 단축 가능 
	}

	
	//오버로딩 
	public void printScores(int size) {
		System.out.println(" -- 성적을 출력합니다. -- ");
		
		//int size = list.current;
		for (int i = 0; i < size; i++) {
			
			Exam exam = list.get(i); 
					//this.exams[i];
			
			int kor = exam.getKor();
			int eng = exam.getEng();
			int math = exam.getMath();

			int total = exam.total();
					//kor + eng + math;
			float avg = exam.avg();
					//total/3.0F;
			
			System.out.println();
			System.out.println(" -- 성적 출력 -- ");
						
			System.out.println("국어 점수입니다 : " + kor);
			System.out.println("영어 점수입니다 : " + eng);
			System.out.println("수학 점수입니다 : " + math);
			System.out.println("총 점수입니다 : " + total);
			System.out.println("평균 점수입니다 : " + avg);
			
		}
		
	}		

}
