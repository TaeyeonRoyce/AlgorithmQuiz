package Boj_Solution.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2992 {
	private final int MAX_NUM = 1000000;
	private int minNum;

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numberString = br.readLine();
		String[] strArr = numberString.split("");

		int originNum = Integer.parseInt(numberString);

		minNum = MAX_NUM;

		int digit = strArr.length;
		boolean[] visited = new boolean[digit];

		int[] arr = new int[digit];
		int[] output = new int[digit];

		for (int i = 0; i < digit; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}

		perm(originNum, arr, output, visited, 0, digit, digit);

		if (minNum == MAX_NUM) {
			System.out.println("0");
			return;
		}

		System.out.printf(minNum + "");

	}

	private void perm(int origin, int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
		if (depth == r) {
			int tmp = arrToInt(output);
			if (tmp > origin) {
				if (tmp < minNum) {
					minNum = tmp;
				}
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(origin, arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	private int arrToInt(int[] arr) {
		String number = "";
		for (int i : arr) {
			number += i;
		}
		return Integer.parseInt(number);
	}
}
