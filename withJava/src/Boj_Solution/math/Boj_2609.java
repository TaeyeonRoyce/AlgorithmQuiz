package Boj_Solution.math;

import java.util.Scanner;

public class Boj_2609 {
    public void solution(){
        Scanner inputs = new Scanner(System.in);
        int a = inputs.nextInt();
        int b = inputs.nextInt();
        if (a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        int lcm = getLCM(a, b);
        int gcd = (a * b) / lcm;
        System.out.println(lcm);
        System.out.println(gcd);
    }

    private int getLCM(int a, int b){
        if (a % b == 0){
            return b;
        }
        return getLCM(b, a % b);
    }

}
