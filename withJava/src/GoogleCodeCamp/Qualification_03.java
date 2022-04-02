package GoogleCodeCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Qualification_03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			List<Integer> diceList = new ArrayList<>();
			String dices = br.readLine();
			StringTokenizer st = new StringTokenizer(dices);
			for (int j = 0; j < N; j++) {
				diceList.add(Integer.parseInt(st.nextToken()));
			}

			int ans = solution(diceList);
			System.out.println("Case #" + (i + 1) + ": " + ans);
		}
	}

	//ex) 3 3 3 3 5 7
	//for   straight [1, 2, 3, 4, 5, 6]
	//		dices    [3, 3, 3, 5, 7]
	private static int solution(List<Integer> diceList) {
		int start = 1;
		Collections.sort(diceList);
		for (Integer integer : diceList) {
			if (start > integer) {
				continue;
			}
			start++;
		}

		return start - 1;
	}
}
