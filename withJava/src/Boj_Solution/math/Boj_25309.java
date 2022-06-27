package Boj_Solution.math;

import java.util.*;

public class Boj_25309 {
	public void solution() {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();

		List<Integer> primeList = findPrimeList(N);

		int[] answer = new int[K];
		for (int i = 0; i < K; i++) {
			answer[i] = primeList.get(0);
		}


	}

	private List<Integer> findPrimeList(int N) {
		List<Integer> primeList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (isPrimeNumber(i)) {
				primeList.add(i);
			}
		}

		return primeList;
	}

	private boolean isPrimeNumber(int number) {
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
