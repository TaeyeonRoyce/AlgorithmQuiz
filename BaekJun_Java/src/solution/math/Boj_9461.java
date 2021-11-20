package solution.math;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_9461 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int T = inputs.nextInt();
        long[] board = new long[100];
        board[0] = 1;
        board[1] = 1;
        board[2] = 1;
        for (int i = 3; i < 100; i++) {
            board[i] = board[i - 3] + board[i - 2];
        }
        for (int i = 0; i < T; i++){
            int N = inputs.nextInt();
            System.out.println(board[N - 1]);

        }
    }
}
