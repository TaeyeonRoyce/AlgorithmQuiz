package Boj_Solution.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj_11286 {

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				a = Math.abs(a);
				b = Math.abs(b);
				if (a > b) return +1;
				if (a.equals(b)) return 0;
				return -1;
			}
		});

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				if (minHeap.isEmpty()) {
					System.out.println(0);
				} else {
					System.out.println(minHeap.poll());
				}
			} else {
				minHeap.add(num);
			}
		}
	}
}
