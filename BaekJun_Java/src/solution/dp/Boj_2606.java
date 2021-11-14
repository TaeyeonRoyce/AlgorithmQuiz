package solution.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_2606 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int networks = inputs.nextInt();
        ArrayList<Boolean> check = new ArrayList<>();
        int cntTrue = 0;
        int newCntTrue = 1;
        int[][] board = new int[networks][2];
        ArrayList<Integer> viruses = new ArrayList<>();


        for (int i = 0; i < N; i++){
            check.add(false);
        }

        for (int i = 0; i < networks; i++){
            board[i][0] = inputs.nextInt();
            board[i][1] = inputs.nextInt();
        }
        check.set(0, true);

        while (cntTrue != newCntTrue) {
            cntTrue = newCntTrue;
            for (int i = 0; i < networks; i++) {
                if (check.get(board[i][0] - 1)) {
                    check.set(board[i][1] - 1, true);
                }
                if (check.get(board[i][1] - 1)) {
                    check.set(board[i][0] - 1, true);
                }
            }
            newCntTrue = Collections.frequency(check, true);
        }
        if (newCntTrue == 1){
            System.out.println(0);
        } else {
            System.out.println(newCntTrue - 1);
        }
    }
}
