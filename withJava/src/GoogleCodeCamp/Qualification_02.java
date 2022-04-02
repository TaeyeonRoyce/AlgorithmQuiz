package GoogleCodeCamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Qualification_02 {

	//exact unit
	private static final int unit = 1000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			//save remained inks by colors
			//not by each printers
			int[] cyan = new int[3];
			int[] magenta = new int[3];
			int[] yellow = new int[3];
			int[] black = new int[3];
			for (int j = 0; j < 3; j++) {
				String CMYK = br.readLine();
				StringTokenizer st = new StringTokenizer(CMYK);
				cyan[j] = Integer.parseInt(st.nextToken());
				magenta[j] = Integer.parseInt(st.nextToken());
				yellow[j] = Integer.parseInt(st.nextToken());
				black[j] = Integer.parseInt(st.nextToken());
			}
			String ans = solution(cyan, magenta, yellow, black);

			System.out.println("Case #" + (i + 1) + ": " + ans);
		}
	}

	private static String solution(int[] cyan, int[] magenta, int[] yellow, int[] black) {
		Arrays.sort(cyan);
		Arrays.sort(magenta);
		Arrays.sort(yellow);
		Arrays.sort(black);

		//To print same color with all printers,
		//only check minimum of each color
		int minC = cyan[0];
		int minM = magenta[0];
		int minY = yellow[0];
		int minB = black[0];

		int minSum = minC + minM + minY + minB;

		//sum of minimums should be bigger than unit(1,000,000)
		if (minSum < unit) {
			return "IMPOSSIBLE";
		}

		//1. calculate left
		//	left = minSum - unit
		//ex) minSum = 1,234,567 -> left = 234,567
		// we don't need to sum 234,567 inks
		int left = minSum - unit;

		//revert unnecessary inks
		if (left > minC) {
			left -= minC;
			minC = 0;
		} else {
			minC -= left;
			return minC + " " + minM + " " + minY + " " + minB;
		}

		if (left > minM) {
			left -= minM;
			minM = 0;
		} else {
			minM -= left;
			return minC + " " + minM + " " + minY + " " + minB;
		}

		if (left > minY) {
			left -= minY;
			minY = 0;
		} else {
			minY -= left;
			return minC + " " + minM + " " + minY + " " + minB;
		}

		if (left > minB) {
			left -= minB;
			minB = 0;
		} else {
			minB -= left;
			return minC + " " + minM + " " + minY + " " + minB;
		}

		return "IMPOSSIBLE";
	}

}
