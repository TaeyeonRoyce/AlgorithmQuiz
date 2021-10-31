package solution.boj.level1;

import java.util.Scanner;

public class Boj_2884 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int A = inputs.nextInt();
        int B = inputs.nextInt();
        inputs.close();
        if (B - 45 < 0) {
            A -= 1;
            if (A < 0) {
                A = 24 + A;
            }
            B += 15;
        }
        else {
            B -= 45;
        }
        System.out.printf("%d %d",A,B);
    }
}