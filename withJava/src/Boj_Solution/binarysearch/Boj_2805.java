package Boj_Solution.binarysearch;

import java.util.Scanner;

public class Boj_2805 {

	public void solution() {
		Scanner inputs = new Scanner(System.in);
		int N = inputs.nextInt();
		long M = inputs.nextInt();

		long start = 0;
		long end = 0;

		long[] treeHeights = new long[N];
		for (int i = 0; i < treeHeights.length; i++) {
			int height = inputs.nextInt();
			treeHeights[i] = height;
			if (height > end) {
				end = height;
			}
		}

		long cutValue = 0;
		while (start < end) {
			long woodsAmount = 0;
			cutValue = (start + end) / 2;
			for (long treeHeight : treeHeights) {
				if (treeHeight > cutValue) {
					woodsAmount += (treeHeight - cutValue);
				}
			}
			if (woodsAmount < M) {
				end = cutValue;
			} else {
				start = cutValue + 1;
			}
		}

		System.out.println(start - 1);
	}

}
