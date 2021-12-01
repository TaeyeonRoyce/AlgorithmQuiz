package solution.implemention;

import java.util.Scanner;

public class Boj_1259 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        while (true) {
            String nums = inputs.next();
            if (nums.equals("0")) {
                break;
            }
            StringBuffer numsSb = new StringBuffer(nums);
            if (nums.equals(numsSb.reverse().toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
