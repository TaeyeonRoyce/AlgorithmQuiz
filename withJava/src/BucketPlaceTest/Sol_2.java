package BucketPlaceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Sol_2 {
	public static void main(String[] args) {
		int[] arr = new int[] {3,3,5,5,8,8,9,9,10,10};
		solution(arr);
	}

	private static int solution(int[] arr) {
		int answer = -1;
		Map<Integer, Integer> map = new HashMap<>();

		//원활한 분리를 위한 Queue사용
		Queue<Integer> pillar = new LinkedList<>();
		List<Integer> ceiling = new ArrayList<>();

		//기둥으로 사용할 수 있는 블록
		for (int i : arr) {
			Integer num = map.get(i);
			if (num == null || num == 0) {
				map.put(i, 1);
			} else if (num == 1) {
				pillar.add(i);
				map.put(i, 0);
			}
		}

		//천장으로 사용할 블록
		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				ceiling.add(key);
			}
		}

		answer = getAnswer(pillar, ceiling);
		System.out.println(answer);
		return answer;
	}

	private static int getAnswer(Queue<Integer> pillar, List<Integer> ceiling) {
		int pillarSize = pillar.size();
		int ceilingSize = ceiling.size();
		if (pillarSize == ceilingSize) {
			int sumOfPillar = pillar.stream().mapToInt(i -> i).sum();
			return sumOfPillar + ceilingSize;
		} else if (pillarSize < ceilingSize) {
			int sumOfPillar = pillar.stream().mapToInt(i -> i).sum();
			return sumOfPillar + pillarSize;
		} else {
			Integer removedPillar = pillar.poll();
			ceiling.add(removedPillar);
			ceiling.add(removedPillar);
			return getAnswer(pillar, ceiling);
		}
	}
}
