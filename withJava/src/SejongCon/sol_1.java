package SejongCon;

import java.util.Scanner;

public class sol_1 {
	public static void main(String[] args) {
		Scanner inputs = new Scanner(System.in);

		int n = inputs.nextInt();
		int a = inputs.nextInt();
		int b = inputs.nextInt();

		if (n > 40 || a > b) {
			System.out.println("no");
		} else {
			System.out.println("yes");
		}
	}
}
