package solution.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Boj_1764 {
	private HashSet<String> listenSet = new HashSet<>();

	public void solution() {
		Scanner inputs = new Scanner(System.in);
		String NM = inputs.nextLine();
		String[] split = NM.split(" ");
		int N = Integer.parseInt(split[0]);
		int M = Integer.parseInt(split[1]);
		ArrayList<String> answerList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String member = inputs.nextLine();
			listenSet.add(member);
		}

		for (int i = 0; i < M; i++) {
			String member = inputs.nextLine();
			if (listenSet.contains(member)) {
				answerList.add(member);
			}
		}
		Collections.sort(answerList);

		System.out.println(answerList.size());
		for (String member : answerList) {
			System.out.println(member);
		}
	}

}
