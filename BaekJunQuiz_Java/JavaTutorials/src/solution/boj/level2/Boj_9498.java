package solution.boj.level2;

import java.util.Scanner;

public class Boj_9498 {
	public static void solution() {
		Scanner inputs = new Scanner(System.in);
		int A = inputs.nextInt();
		inputs.close();
		if (A >= 90) {
			System.out.println("A");
		}
		else if (A >= 80) {
			System.out.println("B");
		}
		else if (A >= 70) {
			System.out.println("C");
		}
		else if (A >= 60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");	
		}
	}
}
