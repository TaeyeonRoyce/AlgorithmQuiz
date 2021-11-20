package solution.math;

import java.util.Scanner;

public class Boj_1016 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        long min = inputs.nextLong();
        long max = inputs.nextLong();
        int answer = 0;
        int maxSqrt = (int)Math.sqrt(max);
        long[] sqrtNums = new long[maxSqrt + 1];
        for (int i = 1; i <= maxSqrt; i++) {
            if (isPrime(i)) {
                sqrtNums[i] = (long) Math.pow(i, 2);
            }
        }

        for (long i = min; i <= max; i++) {
            for (long sqrtNum : sqrtNums) {
                if( sqrtNum  != 0 && i % sqrtNum == 0){
                    answer += 1;
                    break;
                }
            }
        }
        System.out.println(max-min-answer + 1);
    }
    private boolean isPrime(int num){
        if (num == 1){
            return false;
        } else if (num == 2 || num == 3) {
            return true;
        } else{
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if( num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}
