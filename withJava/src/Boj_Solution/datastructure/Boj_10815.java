package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_10815 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int N = Integer.parseInt(s);

		HashSet<String> numSet = new HashSet<>();

		String nums = br.readLine();
		StringTokenizer st = new StringTokenizer(nums);
		for (int i = 0; i < N; i++) {
			numSet.add(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		String searchNums = br.readLine();
		StringTokenizer st2 = new StringTokenizer(searchNums);
		for (int i = 0; i < M; i++) {
			if (numSet.contains(st2.nextToken())) {
				bw.write("1 ");
			} else {
				bw.write("0 ");
			}
		}
		bw.close();
	}
}
