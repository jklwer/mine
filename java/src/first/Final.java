package first;

import java.util.Scanner;

public class Final {
	public static void main(String[] args) {
		
		final int SIZE = 3;
		int[][] engs = new int[SIZE][SIZE];
		Scanner sc = new Scanner(System.in);
		int menu = 0; 
		final int MENU_INPUT = 1;
		final int MENU_PRINT = 2;
		final int MENU_OUT = 3;
		float total[] = new float[SIZE];
		float avg[] = new float[SIZE];
		
		
		while (true) {

			System.out.println(" * 메뉴 * ");
			System.out.println("1. 영어성적 입력 ");
			System.out.println("2. 영어성적 출력 ");
			System.out.println("3. 프로그램 종료 ");
			System.out.println("어디로 갈까요 ? ");
			menu = sc.nextInt();
			
			switch (menu) {
			case MENU_INPUT:
				System.out.println("-- 성적을 입력받겠습니다. --");
				for (int j = 0; j < engs.length; j++) {
					for (int i = 0; i < engs.length; i++) {
						do {
							System.out.print( j+1 + "학년 영어 성적 입력 : ");
							engs[j][i] = sc.nextInt();
							if(engs[j][i] < 0 || engs[j][i] > 100) {
								System.out.println("범위를 벗어난 값");
							}
						} while (engs[j][i] < 0 || engs[j][i] > 100);
					}	
				}
					
				break;
			case MENU_PRINT:
				System.out.println("-- 성적을 출력하겠습니다. --");
				for (int j = 0; j < engs.length; j++) {
					for (int i = 0; i < engs.length; i++) {
						total[j] += engs[j][i];
						avg[j] = total[j]/SIZE;
					}
					System.out.println( j+1 + "학년 총점 : " + total[j]);
					System.out.println( j+1 + "학년 평균 : " + avg[j]);
				}

				break;
			case MENU_OUT:
				System.out.println("종료합니다.");
				return;
				
			default:System.out.println("잘못된 번호 입력  ");
				break;
			}
		}
		
		

	}

}
