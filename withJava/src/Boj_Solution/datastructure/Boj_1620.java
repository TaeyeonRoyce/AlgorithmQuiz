package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_1620 {

	private Map<String, String> docs = new HashMap<>();

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N + 1; i++) {
			String pokemon = br.readLine();
			docs.put(String.valueOf(i), pokemon);
			docs.put(pokemon, String.valueOf(i));
		}

		for (int i = 0; i < M ; i++) {
			System.out.println(docs.get(br.readLine()));
		}
	}
}
