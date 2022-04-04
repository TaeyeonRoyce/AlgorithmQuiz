package Boj_Solution.implemention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1107 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strN = br.readLine();
		int N = Integer.parseInt(strN);
		int M = Integer.parseInt(br.readLine());

		int ans = Math.abs(N - 100);
		if (97 < N && N < 104) {
			System.out.println(ans);
			return;
		} else if (M == 0) {
			System.out.println(strN.split("").length);
			return;
		}

		String brokenNums = br.readLine();
		StringTokenizer st = new StringTokenizer(brokenNums);
		boolean[] exceptNumList = new boolean[10];
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			exceptNumList[num] = true;
		}

		for (int i = 0; i <= 1000000; i++) {
			int channel = i;
			int directNumBtn = i;
			int length = 0;
			if (i == 0 && exceptNumList[0] == false) {
				length = 1;
			}

			while (directNumBtn > 0) {
				if (exceptNumList[directNumBtn % 10]) {
					length = 0;
					break;
				}
				length++;
				directNumBtn = directNumBtn / 10;
			}
			if (length > 0) {
				ans = Math.min(ans, length + Math.abs(channel - N));
			}
		}

		System.out.println(ans);
	}
}
