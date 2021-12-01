package solution.implemention;

import java.util.Scanner;

public class Boj_2920 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        boolean isAscend = false;
        boolean isDescend = false;
        int beforeNum = inputs.nextInt();
        for (int i = 0; i < 7; i++) {
            int num = inputs.nextInt();
            if (beforeNum > num) {
                isDescend = true;
            } else if (beforeNum < num) {
                isAscend = true;
            }
            beforeNum = num;
        }
        if (isAscend && isDescend) {
            System.out.println("mixed");
        } else if (isAscend) {
            System.out.println("ascending");
        } else if (isDescend) {
            System.out.println("descending");
        }
    }
}
