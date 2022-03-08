package Boj_Solution.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18111 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];

		int min = 257;
		int max = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int height = Integer.parseInt(st.nextToken());
				board[i][j] = height;
				if (height > max) {
					max = height;
				}
				if (height < min) {
					min = height;
				}
			}
		}

		int answerHeight = -1;
		int answerTime = Integer.MAX_VALUE;

		for (int i = 0; i <= max; i++) {
			int time = 0;
			int inventory = B;
			for (int[] line : board) {
				for (int value : line) {
					int times = Math.abs(i - value);
					if (value < i) {
						time += 1 * (times);
						inventory -= 1 * (times);
					} else if (value > i) {
						time += 2 * (times);
						inventory += 1 * (times);
					}
				}
			}

			if (inventory >= 0) {
				if (time <= answerTime) {
					answerTime = time;
					answerHeight = i;
				}
			}
		}
		System.out.println(answerTime + " " + answerHeight);
	}


}
