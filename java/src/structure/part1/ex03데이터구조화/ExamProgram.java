package structure.part1.ex03데이터구조화;

import java.util.Scanner;

public class ExamProgram {

	public static void main(String[] args) {
		
		Exam exam = new Exam();
		
		input(exam);
		print(exam);
	}

	private static void print(Exam exam) {
		int kor = exam.kor;
		int eng = exam.eng;
		int math = exam.math;
		System.out.println();
		System.out.println(" -- 성적을 출력합니다. -- ");
		
		int total = kor + eng + math;
		float avg = total/3.0F;
		
		System.out.println("국어 점수입니다 : " + kor);
		System.out.println("영어 점수입니다 : " + eng);
		System.out.println("수학 점수입니다 : " + math);
		System.out.println("총 점수입니다 : " + total);
		System.out.println("평균 점수입니다 : " + avg);
	}

	private static void input(Exam exam) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" -- 성적을 입력받겠습니다. -- ");

		int kor;
		int eng;
		int math;
		
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
		
		exam.kor = kor;
		exam.eng = eng;
		exam.math = math;
		

	}


}
