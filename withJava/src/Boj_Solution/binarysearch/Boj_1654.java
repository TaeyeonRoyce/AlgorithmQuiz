package Boj_Solution.binarysearch;

import java.util.Scanner;

public class Boj_1654 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int K = inputs.nextInt();
        int N = inputs.nextInt();
        int[] lines = new int[K];
        long maxLine = 0;

        for (int i = 0; i < K; i++) {
            lines[i] = inputs.nextInt();
            if (lines[i] > maxLine) {
                maxLine = lines[i];
            }
        }

        maxLine += 1;
        long min = 0;
        long mid = 0;

        while (min < maxLine) {
            int cnt = 0;
            mid = (maxLine + min) / 2;

            for (int line : lines) {
                cnt += line / mid;
            }

            if (cnt < N) {
                maxLine = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
