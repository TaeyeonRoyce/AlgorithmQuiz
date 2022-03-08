package SejongCon;

import java.util.Scanner;

public class sol_2 {
	private static long answer = 0;
	private static final long DIV_NUM = 998244353;

	public static void main(String[] args) {
		Scanner inputs = new Scanner(System.in);

		int N = inputs.nextInt();

		long[][] nums = new long[9][N];

		for (int i = 0; i < 9; i++) {
			nums[i][0] = 1;
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 9; j++) {
				if (j == 0) {
					nums[j][i] = (nums[j][i - 1] + nums[j + 1][i - 1]) % DIV_NUM;
				} else if (j == 8) {
					nums[j][i] = (nums[j][i - 1] + nums[j - 1][i - 1]) % DIV_NUM;
				} else {
					nums[j][i] = (nums[j][i - 1] + nums[j + 1][i - 1] + nums[j - 1][i - 1]) % DIV_NUM;
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			answer += nums[i][N - 1] % DIV_NUM;
		}

		System.out.println(answer % DIV_NUM);
	}
}
