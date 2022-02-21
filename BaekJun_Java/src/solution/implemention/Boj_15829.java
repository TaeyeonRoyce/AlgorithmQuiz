package solution.implemention;

import java.util.Scanner;

public class Boj_15829 {
	private final int n = 31;
	private final int mod = 1234567891;

	public void solution() {
		Scanner inputs = new Scanner(System.in);
		int stringLine = inputs.nextInt();
		String strings = inputs.next();

		long pow = 1;
		long hashValue = 0;
		String[] split = strings.split("");
		for (int i = 0; i < stringLine; i++) {
			hashValue += letterToHashNum(split[i]) * pow;
			pow = (pow *= n) % mod;
		}

		System.out.println(hashValue % mod);
	}

	// a -> 1, b -> 2...
	// z -> 26
	private int letterToHashNum(String singleLetter) {
		char c = singleLetter.charAt(0);
		return (int)c - 96;
	}

}
