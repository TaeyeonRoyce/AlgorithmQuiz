package Boj_Solution.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_11659 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String nums = br.readLine();
		StringTokenizer numSt = new StringTokenizer(nums);
		int[] numSumArray = new int[N + 1];
		numSumArray[0] = 0;
		for (int i = 1; i < N + 1; i++) {
			int num = Integer.parseInt(numSt.nextToken());
			numSumArray[i] = num + numSumArray[i - 1];
		}

		for (int i = 0; i < M; i++) {
			String range = br.readLine();
			StringTokenizer rangeSt = new StringTokenizer(range);
			int startIndex = Integer.parseInt(rangeSt.nextToken());
			int endIndex = Integer.parseInt(rangeSt.nextToken());

			System.out.println(numSumArray[endIndex] - numSumArray[startIndex - 1]);
		}

	}
}
