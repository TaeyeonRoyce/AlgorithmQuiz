package SKTest;

import java.util.HashMap;
import java.util.Map;

public class Sol_1 {
	public static void main(String[] args) {
		int[] cost = new int[] {2, 11, 20, 100, 200, 600};
		System.out.println(solution_1(1999, cost));
		//1999	[]

	}

	private static int solution_1(int money, int[] costs) {
		int answer = 0;

		int[] units = new int[] {1, 5, 10, 50, 100, 500}; //동전 단위
		Map<Integer, Integer> unitCosts = new HashMap<>();

		for (int i = 0; i < units.length; i++) {
			unitCosts.put(units[i], costs[i]); //동전단위별 생산 비용 저장
		}

		//동전 단위별 최소 비용 저장
		//ex)
		// 100원에 30원, 500원에 1000원의 비용이 드는 경우,
		// (100, 30), (500, 1000)
		// 500원을 생상하기 보단 100을 5번 생산하는 것이 최솟값임.
		// => (500 / 100) * 30원
		// 500원 생산의 최소 비용으로 저장
		for (int i = 0; i < units.length; i++) {
			int unit1 = units[i];
			int unit1Cost = unitCosts.get(unit1);
			for (int j = i + 1; j < units.length; j++) {
				int unit2 = units[j];
				int unit2Cost = unitCosts.get(unit2);
				if ((unit2 / unit1) * unit1Cost < unit2Cost) { //(500 / 100) * 30원
					unitCosts.put(unit2, (unit2 / unit1) * unit1Cost); // 최소 비용 저장
				}
			}
		}

		int cur = units.length - 1;
		while (money > 0 && cur >= 0) {
			int unit = units[cur];
			int cost = unitCosts.get(unit);

			if (money >= unit) {
				money -= unit;
				answer += cost;
			} else {
				cur--;
			}
		}
		return answer;
	}
}


