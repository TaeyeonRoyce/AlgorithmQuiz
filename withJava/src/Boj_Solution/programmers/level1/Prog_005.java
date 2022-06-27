package Boj_Solution.programmers.level1;

import java.util.*;

public class Prog_005 {
	private final int REPORTER_INDEX = 0;
	private final int REPORTED_INDEX = 1;


	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		HashSet<String> afterDistinctSet = new HashSet<>(Arrays.asList(report));
		List<User> userList = new ArrayList<>();
		Map<String, Integer> reportCntMap = new HashMap<>();

		for (String nickname : id_list) {
			userList.add(new User(nickname));
		}

		for (String reportInfo : afterDistinctSet) {
			String[] reportRelation = reportInfo.split(" ");
			String reporter = reportRelation[REPORTER_INDEX];
			String reported = reportRelation[REPORTED_INDEX];

			for (User user : userList) {
				if (user.getNickname().equals(reporter)) {
					user.addReports(reported);
					break;
				}
			}

			if (!reportCntMap.containsKey(reported)) {
				reportCntMap.put(reported, 1);
				continue;
			}

			int reportedCnt = reportCntMap.get(reported);
			reportCntMap.put(reported, reportedCnt + 1);
		}

		List<String> blockedUserList = new ArrayList<>();

		for (String user: reportCntMap.keySet()) {
			if (reportCntMap.get(user) >= k) {
				blockedUserList.add(user);
			}
		}

		for (int i = 0; i < id_list.length; i++) {
			answer[i] = userList.get(i).countAlerts(blockedUserList);
		}


		return answer;
	}
}

class User {
	private String nickname;
	private List<String> reportList = new ArrayList<>();

	public User(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void addReports(String nickname) {
		reportList.add(nickname);
	}

	public int countAlerts(List<String> blockedUserList) {
		int cnt = 0;
		for (String s : reportList) {
			if (blockedUserList.contains(s)) {
				cnt++;
			}
		}
		return cnt;
	}

}