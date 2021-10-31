package solution.boj.level1;

import java.util.Scanner;

public class Boj_10871 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int X = inputs.nextInt();
        for (int i = 0; i < N; i++) {
            int A = inputs.nextInt();
            if (A < X) {
                System.out.printf("%d ",A);
            }
        }
        inputs.close();
    }

}