package solution.boj.level2;

import java.util.Scanner;

public class Boj_1330 {
	public static void solution() {
		Scanner inputs = new Scanner(System.in);
		int A = inputs.nextInt();
		int B = inputs.nextInt();
		inputs.close();
		if (A > B) {
			System.out.println(">");
		}
		else if (A < B) {
			System.out.println("<");	
		}
		else if (A == B) {
			System.out.println("==");	
		}
	}
}
