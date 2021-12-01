package solution.math;

import java.util.Scanner;

public class Boj_11050 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int K = inputs.nextInt();
        int answer = 1;
        for (int i = N; i > N - K; i--) {
            answer *= i;

        }
        for (int i = 1; i <= K; i++) {
            answer /= i;
        }
        System.out.println(answer);
    }
}
