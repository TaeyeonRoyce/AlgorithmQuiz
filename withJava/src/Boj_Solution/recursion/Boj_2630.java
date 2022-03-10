package Boj_Solution.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2630 {
	private int[][] board;
	private int white = 0;
	private int blue = 0;

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		board = new int[T][T];

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < T; j++) {
				String color = st.nextToken();
				board[i][j] = Integer.parseInt(color);
			}
		}
		checkColorPaper(0, 0, T);

		System.out.println(white);
		System.out.println(blue);
	}

	private void checkColorPaper(int startX, int startY, int range) {
		int color = board[startX][startY];
		if (range == 1) {
			isPaper(color);
			return;
		}

		for (int y = 0; y < range; y++) {
			for (int x = 0; x < range; x++) {
				if (board[startX + x][startY + y] != color) {
					int halfRange = range / 2;

					checkColorPaper(startX, startY, halfRange);
					checkColorPaper(startX + halfRange, startY, halfRange);
					checkColorPaper(startX, startY + halfRange, halfRange);
					checkColorPaper(startX + halfRange, startY + halfRange, halfRange);

					return;
				}
			}
		}

		isPaper(color);
	}

	private void isPaper(int color) {
		if (color == 1) {
			++blue;
			return;
		}
		++white;
		return;
	}
}

