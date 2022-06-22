package CodeGround.solutions;

import java.util.Scanner;

public class Practice_122 {
	static int Answer;
	static int[] bufferArr;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 0; test_case < T; test_case++) {
			Answer = 0;
			long t1 = System.currentTimeMillis();
			/////////////////////////////////////////////////////////////////////////////////////////////
			int N = sc.nextInt();

			int[] nums = new int[N + 1];
			bufferArr = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				int input = sc.nextInt();
				nums[i] = input;
			}

			/* It takes O(n^2)
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
			 		if (nums[i] > nums[j]) {
			 			Answer++;
					}
				}
			}
			*/

			divideArr(nums, 1, N);

			/////////////////////////////////////////////////////////////////////////////////////////////
			long t2 = System.currentTimeMillis();
			// Print the answer to standard output(screen).

			System.out.println("Case #" + (test_case + 1));
			System.out.println(Answer);
			// System.out.println((t2 - t1) + "ms");
		}
	}

	private static void divideArr(int[] nums, int start, int end) {
		if (start >= end) {
			return;
		}

		int middle = (start + end) / 2;
		divideArr(nums, start, middle);
		divideArr(nums, middle + 1, end);

		mergeTwoArr(nums, start, end);
	}

	private static void mergeTwoArr(int[] nums, int start, int end) {
		int x = start;
		int mid = (start + end) / 2;
		int y = mid + 1;
		int cursor = start;

		while (x <= mid || y <= end) {
			if (y > end || (x <= mid && nums[x] < nums[y])) {
				bufferArr[cursor] = nums[x++];
			} else {
				Answer += (mid - x + 1);
				bufferArr[cursor] = nums[y++];
			}
			cursor++;
		}

		for (int i = start; i <= end; i++) {
			nums[i] = bufferArr[i];
		}
	}
}
