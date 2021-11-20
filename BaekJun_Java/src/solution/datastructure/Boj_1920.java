package solution.datastructure;

import java.util.Scanner;

public class Boj_1920 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int[] board = new int[N];
        for (int i = 0; i < N; i++){
            board[i] = inputs.nextInt();
        }
        int M = inputs.nextInt();
        for (int i = 0; i < M; i++){
            int nums = inputs.nextInt();
            int count = 0;
            for (int j : board) {
                if (j == nums){
                    count += 1;
                }
            }
            System.out.println(count);
        }
    }
}
