package SKTest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Sol2_2 {
	public static void main(String[] args) {
		String[] arr = new String[] {"1", "1", "1", "1", "1", "1", "1"};
		String[] process = new String[] {"write 1 12 1 5 8", "read 2 3 0 2", "read 5 5 1 2", "read 7 5 2 5",
			"write 13 4 0 1 3", "write 19 3 3 5 5", "read 30 4 0 6", "read 32 3 1 5"};
		// String[] arr = new String[] {"1","2","4","3","3","4","1","5"};
		// String[] process = new String[] {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};
		solution(arr, process);
	}

	private static String[] solution(String[] arr, String[] processes) {
		String[] answer = {};
		List<Process> processList = new ArrayList<>();

		for (String processString : processes) {
			String[] processInfo = processString.split(" ");
			String type = processInfo[0];
			if (type.equals("read")) {
				processList.add(new ReadProcess(processInfo));
				continue;
			}
			processList.add(new WriteProcess(processInfo));
		}

		WorkFlow workFlow = new WorkFlow(arr, processList);
		workFlow.run();

		answer = workFlow.getResult();
		System.out.println(Arrays.toString(answer));

		return answer;
	}
}

class WorkFlow {
	int time = 1;
	int cursor = 0;
	int unusedTime = 1;

	String[] arr;
	List<Process> processList;

	Deque<Process> currentProcessList = new ArrayDeque<>();
	Deque<Process> waitReadQueue = new ArrayDeque<>();
	Deque<Process> waitWriteQueue = new ArrayDeque<>();

	public WorkFlow(String[] arr, List<Process> processList) {
		this.arr = arr;
		this.processList = processList;
	}

	public void run() {
		while (!isAllProcessDone()) {
			if (cursor < processList.size() && isNewProcess()) {
				Process newProcess = processList.get(cursor);
				cursor++;

				if (newProcess instanceof ReadProcess) {
					if (isProcessWriting() || !waitWriteQueue.isEmpty()) {
						waitReadQueue.add(newProcess);
					} else {
						currentProcessList.add(newProcess);
					}
				} else if (newProcess instanceof WriteProcess) {
					if (currentProcessList.isEmpty()) {
						currentProcessList.add(newProcess);
					} else {
						waitWriteQueue.add(newProcess);
					}
				}
			}

			if (isProcessEmpty()) {
				if (waitWriteQueue.isEmpty() && waitReadQueue.isEmpty()){
					time++;
					continue;
				} else if (waitWriteQueue.isEmpty()) {
					while (!waitReadQueue.isEmpty()) {
						currentProcessList.add(waitReadQueue.poll());
					}
				} else {
					currentProcessList.add(waitWriteQueue.poll());
				}
			}

			for (Process process : currentProcessList) {
				process.progress(arr);
				if (process instanceof WriteProcess) {
					arr = ((WriteProcess)process).work(arr);
				}
			}
			unusedTime++;
			time++;
		}
	}

	private boolean isNewProcess() {
		if (processList.get(cursor).startTime == this.time) {
			return true;
		}

		return false;
	}

	private boolean isProcessWriting() {
		for (Process process : currentProcessList) {
			if (process instanceof WriteProcess) {
				return true;
			}
		}
		return false;
	}

	private boolean isProcessEmpty() {
		for (Process process : currentProcessList) {
			if (!process.isKilled) {
				return false;
			}
		}
		return true;
	}

	private boolean isAllProcessDone() {
		for (Process process : processList) {
			if (!process.isKilled) {
				return false;
			}
		}
		return true;
	}

	public String[] getResult() {
		List<String> answer = new ArrayList<>();
		for (Process process : processList) {
			if (process instanceof ReadProcess) {
				answer.add(((ReadProcess)process).readResult);
			}
		}

		answer.add(String.valueOf(unusedTime));

		String[] result = new String[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			result[i] = answer.get(i);
		}
		return result;
	}

}

abstract class Process {
	int startTime;
	int duration;
	int startRange;
	int endRange;
	boolean isKilled = false;

	abstract public void progress(String[] arr);

}

class ReadProcess extends Process {
	String readResult;

	public ReadProcess(String[] processInfo) {
		this.startTime = Integer.parseInt(processInfo[1]);
		this.duration = Integer.parseInt(processInfo[2]);
		this.startRange = Integer.parseInt(processInfo[3]);
		this.endRange = Integer.parseInt(processInfo[4]);
	}

	@Override
	public void progress(String[] arr) {
		if (isKilled) {
			return;
		}
		duration -= 1;
		work(arr);
	}

	private void work(String[] arr) {
		if (duration == 0) {
			isKilled = true;
			readResult = arr[startRange];
			for (int i = startRange + 1; i <= endRange; i++) {
				readResult += arr[i];
			}
		}
	}
}

class WriteProcess extends Process {
	int editNum;

	public WriteProcess(String[] processInfo) {
		this.startTime = Integer.parseInt(processInfo[1]);
		this.duration = Integer.parseInt(processInfo[2]);
		this.startRange = Integer.parseInt(processInfo[3]);
		this.endRange = Integer.parseInt(processInfo[4]);
		this.editNum = Integer.parseInt(processInfo[5]);
	}

	@Override
	public void progress(String[] arr) {
		if (isKilled) {
			return;
		}
		duration -= 1;
		work(arr);
	}

	public String[] work(String[] arr) {
		if (duration == 0) {
			isKilled = true;
			for (int i = startRange; i <= endRange; i++) {
				arr[i] = String.valueOf(editNum);
			}
		}

		return arr;
	}
}

