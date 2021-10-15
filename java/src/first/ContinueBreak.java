package first;

import java.util.Scanner;

public class ContinueBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 0;
		System.out.print("스페이스로 구분해서 숫자 읽기");
		
		while (sc.hasNext()) {
			n = sc.nextInt();
			
			if(n<10) {
				continue;
			}
			if(n > 100) {
				break;
			}
			System.out.println(n);
		}
		
		
	}

}
