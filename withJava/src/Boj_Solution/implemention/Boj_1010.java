package Boj_Solution.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1010 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			long answer = getAnswer(br);
			System.out.println(answer);
		}
	}

	private long getAnswer(BufferedReader br) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long answer = 1;
		//mCn
		for (int i = (M - N) + 1; i <= M; i++) {
			answer *= i;
		}
		for (int i = 1; i <= N; i++) {
			answer /= i;
		}
		return answer;
	}
}
