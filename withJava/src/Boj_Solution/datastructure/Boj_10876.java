package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_10876 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> numSet = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			numSet.add(num);
		}

		List<Integer> sortedNums = numSet.stream().sorted().collect(Collectors.toList());
		for (Integer sortedNum : sortedNums) {
			System.out.printf("%d ", sortedNum);
		}
	}
}

