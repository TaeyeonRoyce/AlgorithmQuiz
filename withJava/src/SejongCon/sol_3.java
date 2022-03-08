package SejongCon;

import java.util.Arrays;
import java.util.Scanner;

public class sol_3 {
	static int[] ai;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner inputs = new Scanner(System.in);

		int N = inputs.nextInt();

		ai = new int[N];
		int[] bi = new int[N];

		for (int i = 0; i < N; i++) {
			ai[i] = inputs.nextInt();
		}

		for (int i = 0; i < N; i++) {
			bi[i] = inputs.nextInt();
		}

		permutation(bi, 0, N);
		System.out.println(answer);
	}

	static void permutation(int[] arr, int depth, int N) {
		if (depth == N) {
			if (cmpArr(arr)) {
				answer += 1;
			}
			return;
		}

		for (int i = depth; i < N; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, N);
			swap(arr, depth, i);
		}
	}

	static void swap(int[] arr, int depth, int i) {
		int temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	static boolean cmpArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < ai[i]) {
				return false;
			}
		}
		return true;
	}
}
