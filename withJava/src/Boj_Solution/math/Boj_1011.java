package Boj_Solution.math;

import java.util.Scanner;

public class Boj_1011 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int T = inputs.nextInt();
        for (int i = 0; i < T; i++) {
            int x = inputs.nextInt();
            int y = inputs.nextInt();
            int between = y - x;
            int answer = 1;
            if (between == 1){
            } else{
                answer = (int)Math.ceil(Math.sqrt(between)) + 1;
            }
            System.out.println(answer);
        }
    }
}
