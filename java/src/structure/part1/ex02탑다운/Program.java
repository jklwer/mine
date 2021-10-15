package structure.part1.ex02탑다운;

import java.util.Scanner;

public class Program {	
	
	public static void main(String[] args) {
		
		int[][] lottos = null;
		int menu;
		boolean running = true;
		
		while(running) {
			menu = inputMenu();
			
			switch (menu) {
			case 1:
				lottos = createLottoAuto();
				break;
			case 2:
				lottos = createLottoSelf();
				break;
			case 3:
				printLottos(lottos);
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				running = false;
				return;
			default:
			}
		}
	}
		private static void printLottos(int[][] lottos) {
		// TODO Auto-generated method stub
		
		}

		private static int[][] createLottoSelf() {
//			Scanner sc = new Scanner(System.in);
//			int[][] selfLoto;
//			for (int i = 0; i < selfLoto.length; i++) {
//				for (int j = 0; j < selfLoto.length; j++) {
//					selfLoto = new int[i][j];
//					while (sc.hasNext()) {
//						selfLoto[i][j] = ;
//					}
				return null;
//				}
//			}
			
		}

		private static int[][] createLottoAuto() {
			// TODO Auto-generated method stub
			return null;
		}

		private static int inputMenu() {
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			return num;
		}
}
