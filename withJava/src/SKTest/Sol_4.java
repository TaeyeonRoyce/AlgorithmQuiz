package SKTest;

public class Sol_4 {

	public static void main(String[] args) {
		int[][] edges = new int[][] {{0, 1}, {0, 2}, {1, 3}, {1, 4}};
		solution(5, edges);
	}

	private static long solution(int n, int[][] edges) {
		long answer = 0;
		return answer;
	}
}

class Node {

	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
		left = null;
		right = null;
	}
}