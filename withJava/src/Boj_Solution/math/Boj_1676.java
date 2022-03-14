package Boj_Solution.math;

import java.util.Scanner;

public class Boj_1676 {

	public void solution() {
		Scanner inputs = new Scanner(System.in);

		int num = inputs.nextInt();
		int count = 0;

		while (num >= 5) {
			count += num / 5;
			num /= 5;
		}
		System.out.println(count);

	}

}
