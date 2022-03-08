package Boj_Solution.recursion;

import java.util.Scanner;

public class Boj_1074 {
	private int answer = 0;

	public void solution() {
		Scanner inputs = new Scanner(System.in);
		int N = inputs.nextInt();
		int r = inputs.nextInt();
		int c = inputs.nextInt();

		int size = (int) Math.pow(2, N);

		recursion(r, c, size);
		System.out.println(answer);
	}

	/**
	 * 사분면
	 *
	 * 1  |  2
	 * ㅡㅡㅡㅡㅡ
	 * 3  |  4
	 *
	 */

	private void recursion(int r, int c, int size) {
		int halfSize = size / 2;
		if (size == 1) {
			return;
		}
		if (r < halfSize && c < halfSize) {
			// 1사분면
			recursion(r, c, halfSize);
		} else if (r < halfSize && c >= halfSize) {
			// 2사분면
			answer += size * size / 4;
			recursion(r, c - halfSize, halfSize);
		} else if (r >= halfSize && c < halfSize) {
			// 3사분면
			answer += (size * size / 4) * 2;
			recursion(r - halfSize, c, halfSize);
		} else if (r >= halfSize && c >= halfSize) {
			// 4사분면
			answer += (size * size / 4) * 3;
			recursion(r - halfSize, c - halfSize, halfSize);
		}
	}
}
