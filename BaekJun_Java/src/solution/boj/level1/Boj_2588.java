
package solution.boj.level1;

import java.util.Scanner;

public class Boj_2588 {
    public void solution() {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        String B = input.next();
        input.close();

        System.out.println(A * (B.charAt(2) -'0'));
        System.out.println(A * (B.charAt(1) -'0'));
        System.out.println(A * (B.charAt(0) -'0'));
        System.out.println(A * Integer.parseInt(B));


    }
}