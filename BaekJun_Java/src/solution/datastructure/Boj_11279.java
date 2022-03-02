package solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11279 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer lhs, Integer rhs) {
				if (lhs < rhs) return +1;
				if (lhs.equals(rhs)) return 0;
				return -1;
			}
		});

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (maxHeap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(maxHeap.poll());
				}
			} else {
				maxHeap.add(num);
			}
		}
	}
}
