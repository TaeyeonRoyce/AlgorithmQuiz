package Boj_Solution.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1946 {
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		int T = Integer.parseInt(s);

		for (int i = 0; i < T; i++) {
			test(br, bw);
		}
	}

	private void test(BufferedReader br, BufferedWriter bw) throws IOException {
		int N = Integer.parseInt(br.readLine());
		List<IntervieweeScore> intervieweeScores = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String scoreInfo = br.readLine();
			StringTokenizer st = new StringTokenizer(scoreInfo);
			int paper = Integer.parseInt(st.nextToken());
			int interview = Integer.parseInt(st.nextToken());
			IntervieweeScore interviewee = new IntervieweeScore(paper, interview);

			intervieweeScores.add(interviewee);
		}

		Collections.sort(intervieweeScores);

		int minScore = 0;
		int ans = 1;
		for (IntervieweeScore i : intervieweeScores) {
			if (i.paper == 1) {
				minScore = i.interview;
				continue;
			}

			if (i.interview < minScore) {
				ans++;
				minScore = i.interview;
			}
		}

		System.out.println(ans);
	}
}

class IntervieweeScore implements Comparable<IntervieweeScore> {
	int paper;
	int interview;

	public IntervieweeScore(int paper, int interview) {
		this.paper = paper;
		this.interview = interview;
	}

	@Override
	public int compareTo(IntervieweeScore o) {
		return (paper - o.paper);
	}
}