package GoogleCodeCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Qualification_01 {

	private static String rowInitCeiling = "";
	private static String rowInitContent = "";
	private static String rowWrapper = "";
	private static String rowContent = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String RnC = br.readLine();
			StringTokenizer st = new StringTokenizer(RnC);
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			solution(R, C, i + 1);
		}
	}

	private static void solution(int row, int column, int testCase) {
		System.out.println("Case #" + testCase +":");
		rowInitCeiling = "..";
		rowInitContent = "..";
		rowWrapper = "+-";
		rowContent = "|.";
		for (int i = 0; i < column - 1; i++) {
			rowInitCeiling += "+-";
			rowInitContent += "|.";
			rowWrapper += "+-";
			rowContent += "|.";
		}

		rowInitCeiling += "+";
		rowInitContent += "|";
		rowWrapper += "+";
		rowContent += "|";

		for (int i = 0; i < (row * 2) + 1; i++) {
			printLine(i);
		}
	}

	private static void printLine(int rowCnt) {
		if (rowCnt == 0) {
			System.out.println(rowInitCeiling);
		} else if (rowCnt == 1) {
			System.out.println(rowInitContent);
		} else if (rowCnt % 2 == 0) {
			System.out.println(rowWrapper);
		} else if (rowCnt % 2 == 1) {
			System.out.println(rowContent);
		}
	}
}
