package CodeGround.solutions;

import java.util.Scanner;

public class NumberOfInversion {
	static int Answer;

	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			long t1 = System.currentTimeMillis();
			/////////////////////////////////////////////////////////////////////////////////////////////
			int N = sc.nextInt();

			int[] nums = new int[N];
			boolean[] isNum = new boolean[N];
			for (int i = 0; i < N; i++) {
				int input = sc.nextInt();
				nums[i] = input;
				isNum[input - 1] = true;
			}

			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					if (nums[i] > nums[j]) {
						Answer++;
					}
				}
			}

			/////////////////////////////////////////////////////////////////////////////////////////////
			long t2 = System.currentTimeMillis();
			// Print the answer to standard output(screen).

			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
			System.out.println((t2 - t1) + "ms");
		}
	}
}
