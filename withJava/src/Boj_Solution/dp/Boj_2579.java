package Boj_Solution.dp;

import java.util.Scanner;

public class Boj_2579 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int[] board = new int[N + 1];
        for (int i = 1; i < N + 1; i++){
            board[i] = inputs.nextInt();
        }
        int[] memo = new int[N + 1];
        memo[1] = board[1];

        if (N >= 2) {
            memo[2] = board[1] + board[2];
        }
        for (int i = 3; i <= N; i++) {
            memo[i] = Math.max(memo[i - 2] , memo[i - 3] + board[i - 1]) + board[i];
        }
        System.out.println(memo[N]);
    }
}
