package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_5052 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int T = Integer.parseInt(s);

		for (int i = 0; i < T; i++) {
			System.out.println(test(br));
		}
	}

	private String test(BufferedReader br) throws IOException {
		int n = Integer.parseInt(br.readLine());

		String[] nums = new String[n];
		for (int i = 0; i < n; i++) {
			String num = br.readLine();
			nums[i] = num;
		}
		Arrays.sort(nums);

		for (int i = 0; i < n - 1; i++) {
			if (nums[i + 1].startsWith(nums[i])) {
				return "NO";
			}
		}
		return "YES";
	}
}
