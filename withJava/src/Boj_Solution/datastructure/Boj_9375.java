package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_9375 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int T = Integer.parseInt(s);
		for (int i = 0; i < T; i++) {
			test(br);
		}
	}

	private void test(BufferedReader br) throws IOException {
		String s = br.readLine();
		int n = Integer.parseInt(s);
		Map<String, Integer> closet = new HashMap<>();

		int answer = 1;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cloth = st.nextToken();
			String type = st.nextToken();

			if (closet.get(type) == null) {
				closet.put(type, 0);
			}

			closet.put(type, closet.get(type) + 1);
		}

		for (Integer value : closet.values()) {
			answer *= (value + 1);
		}

		System.out.println(answer - 1);
	}
}
