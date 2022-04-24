package Boj_Solution.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Boj_17626 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		int number = Integer.parseInt(n);

		List<Integer> squares = new ArrayList<>();

		int subNum = 1;
		while (subNum * subNum <= number) {
			squares.add(subNum * subNum);
			subNum++;
		}

		int[] memo = new int[number + 1];
		memo[0] = 0;
		memo[1] = 1;
		for (int i = 2; i < number + 1; i++) {
			if (squares.contains(i)) {
				memo[i] = 1;
				continue;
			}

			int minCnt = 5;
			for (int j = 0; j < squares.size(); j++) {
				int square = squares.get(j);
				if (square > i) {
					break;
				}
				int tempCnt = memo[i - square] + 1;
				if (tempCnt < minCnt) {
					minCnt = tempCnt;
				}
			}
			memo[i] = minCnt;
		}

		System.out.println(memo[number]);
	}
}
