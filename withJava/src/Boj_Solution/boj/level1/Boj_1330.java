package Boj_Solution.boj.level1;

import java.util.Scanner;

public class Boj_1330 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int A = inputs.nextInt();
        int B = inputs.nextInt();
        inputs.close();
        if (A > B) {
            System.out.println(">");
        }
        else if (A < B) {
            System.out.println("<");
        }
        else if (A == B) {
            System.out.println("==");
        }
    }
}