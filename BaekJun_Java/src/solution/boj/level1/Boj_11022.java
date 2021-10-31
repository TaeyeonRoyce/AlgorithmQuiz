package solution.boj.level1;

import java.util.Scanner;

public class Boj_11022 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int T = inputs.nextInt();
        for (int i = 0; i < T; i++) {
            int A = inputs.nextInt();
            int B = inputs.nextInt();
            System.out.printf("Case #%d: %d + %d = %d%n",i+1,A,B,A+B);
        }
        inputs.close();
    }

}