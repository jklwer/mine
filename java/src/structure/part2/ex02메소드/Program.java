package structure.part2.ex02메소드;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		ExamList list = new ExamList();	//객체가 만들어질떄 값 초기화 

		//ExamList.init(list);
		//list.init(); 생성자로 대체 
		//list.current = 3;
		
		boolean keepOrOut = true;
		while(keepOrOut) {
			
			int menu = menu();
	
			switch (menu) {
			case 1:
				//ExamList.inputScores(list);
				list.inputScores();
				break;
			case 2:
				//ExamList.printScores(list); 
				list.printScores();
				break;
			case 3:
				System.out.println(" -- 프로그램을 종료합니다. -- ");
				keepOrOut = false;
				break;
				
			default: System.out.println(" -- 잘못된 번호 입력. -- ");
			}
		}
	}
	



	static int menu() {
		System.out.println("어디로 갈까요?");
		System.out.println("1. 시험 점수 입력");
		System.out.println("2. 시험 점수 출력");
		System.out.println("3. 프로그램 종료 ");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		return num;
	}

}
	
