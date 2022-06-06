package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_17219 {

	private HashMap<String, String> webPwd = new HashMap<>();

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String webInfo = br.readLine();
			StringTokenizer webPwdToken = new StringTokenizer(webInfo);
			String website = webPwdToken.nextToken();
			String pwd = webPwdToken.nextToken();
			webPwd.put(website, pwd);
		}

		for (int i = 0; i < M; i++) {
			String searchWeb = br.readLine();
			System.out.println(webPwd.get(searchWeb));
		}
	}
}
