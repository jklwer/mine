package first;

import java.util.Scanner;

public class DoWhile {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ko1 = 0;

		for (int i = 0; i < 3; i++) {
			System.out.println("성적 입력");
			
			System.out.print("국어 : ");
			ko1 = sc.nextInt();
	
			if(ko1 < 0 || ko1 > 100) {
				System.out.println("범위를 벗어난 성적");
			}
			while (ko1 < 0 || ko1 > 100);			
		}

	}
}