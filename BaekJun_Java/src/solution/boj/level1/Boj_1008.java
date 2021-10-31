package solution.boj.level1;

import java.util.*;

public class Boj_1008 {
    public void solution() {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        double answer = (double)A / (double)B;
        System.out.println(answer);
        scanner.close();
    }
}