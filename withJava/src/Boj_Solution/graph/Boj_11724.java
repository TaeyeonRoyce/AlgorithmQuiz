package Boj_Solution.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11724 {

	private int[][] graph;
	private boolean[] visited;

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for(int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		int result = 0 ;
		for(int i = 1; i <= N; i++) {
			if(visited[i] == false) {
				dfs(i, N);
				result++;
			}
		}

		System.out.println(result);
		return;
	}

	private void dfs(int index, int N) {
		if(visited[index] == true)
			return;
		else {
			visited[index] = true;
			for(int i = 1; i <= N; i++) {
				if(graph[index][i] == 1) {
					dfs(i, N);
				}
			}
		}
	}
}
