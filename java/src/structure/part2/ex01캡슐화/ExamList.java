package structure.part2.ex01캡슐화;

import java.util.Scanner;

public class ExamList {
	Exam[] exams;
	int current;
	
	//오버로딩 
	static void printScores(ExamList list, int size) {
		System.out.println(" -- 성적을 출력합니다. -- ");
		
		//int size = list.current;
		Exam[] exams = list.exams;
		
		for (int i = 0; i < size; i++) {
			Exam exam = exams[i];
			
			int kor = exam.kor;
			int eng = exam.eng;
			int math = exam.math;

			int total = kor + eng + math;
			float avg = total/3.0F;
			
			System.out.println();
			System.out.println(" -- 성적 출력 -- ");
						
			System.out.println("국어 점수입니다 : " + kor);
			System.out.println("영어 점수입니다 : " + eng);
			System.out.println("수학 점수입니다 : " + math);
			System.out.println("총 점수입니다 : " + total);
			System.out.println("평균 점수입니다 : " + avg);
			
		}
		
	}	

	static void printScores(ExamList list) {
		printScores(list, list.current);
		//똑같은 기능의 함수를 두번 호출할 경우 코드집중화로 코드 단축 가능 
	}

	static void inputScores(ExamList list) {
		
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
			
			Exam exam = new Exam();
			exam.kor = kor;
			exam.eng = eng;
			exam.math = math;
		
			Exam[] exams = list.exams;
			int size = list.current;
			
			if(exams.length == size) {
				//배열의 총 길이와 현재 가리키는 값이 같을 때 = 배열에 남은 공간이 없을 때 
				//크기가 더 큰 새로운 배열을 생성
				Exam[] temp = new Exam[size + 5];
				//exams의 데이터를 temp로 옮기기 (값을 이주시키기)
				for (int i = 0; i < size; i++) {
					temp[i] = exams[i];
				//list.exams가 temp의 주소를 참조하도록 
				list.exams = temp;
					
				}
			}
			
			list.exams[list.current] = exam;
			list.current++;

		}

	
	public static void init(ExamList list) {
		list.exams = new Exam[3];
		list.current = 0;		
	}

}
