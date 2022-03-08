package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_7662 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			eachTest(br);
		}
	}

	private void eachTest(BufferedReader br) throws IOException {

		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		int k = Integer.parseInt(br.readLine());
		for (int j = 0; j < k; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String calcType = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if (calcType.equals("I")) {
				maxHeap.add(num);
				minHeap.add(num);
			} else if (!maxHeap.isEmpty() &&
					calcType.equals("D") && num == 1) {
				minHeap.remove(maxHeap.poll());
			} else if (!minHeap.isEmpty() &&
					calcType.equals("D") && num == -1) {
				maxHeap.remove(minHeap.poll());
			}
		}

		if (maxHeap.isEmpty() && minHeap.isEmpty()) {
			System.out.println("EMPTY");
		} else if (maxHeap.isEmpty()) {
			Integer min = minHeap.poll();
			printAnswer(min, min);
		} else if (minHeap.isEmpty()) {
			Integer max = maxHeap.poll();
			printAnswer(max, max);
		} else {
			Integer max = maxHeap.poll();
			Integer min = minHeap.poll();

			printAnswer(max, min);
		}

	}

	private void printAnswer(int max, int min) {
		System.out.println(max + " "  + min);
	}
}
