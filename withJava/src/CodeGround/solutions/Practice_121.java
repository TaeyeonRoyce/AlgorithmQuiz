package CodeGround.solutions;
/*
You should use the standard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful. 
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
public class Practice_121 {
	static int Answer;
	public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */		

		/*
		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));


		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {
			/////////////////////////////////////////////////////////////////////////////////////////////
			Answer = getAnswer(sc);
			/////////////////////////////////////////////////////////////////////////////////////////////

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);
		}
	}

	private static int getAnswer(Scanner sc) {
		int N, K;
		N = sc.nextInt();
		K = sc.nextInt();
		Map<Integer, Integer> nums = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (nums.get(num) == null) {
				nums.put(num, 1);
			} else {
				nums.put(num, 2);
			}
		}

		int dis = 0;
		while (true) {
			if (isAvailable(K + dis, nums)) {
				return K + dis;
			} else if (isAvailable(K - dis, nums)) {
				return K - dis;
			}
			dis++;
		}
	}

	private static boolean isAvailable(int target, Map<Integer, Integer> nums) {
		for (Integer key : nums.keySet()) {
			int amount = nums.get(key);
			if (target % key != 0) {
				continue;
			} else if (nums.get(target / key) != null) {
				if ((key == target / key) && amount <= 1) {
					return false;
				}

				return true;
			}
		}

		return false;
	}
}