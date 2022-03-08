package Boj_Solution.programmers.level1;

import java.util.Arrays;

public class prog_004 {
    public void solution() {
        main_solution(118372);
    }

    public long main_solution(long n) {
        int length = Long.toString(n).length();
        long[] numbers = new long[length];
        for (int i = 0; i < length; i++){
            numbers[i] = n % 10;
            n /= 10;
        }
        Arrays.sort(numbers);
        long answer = 0;
        for (int i = 0; i < length; i++){
            answer += numbers[i]*(Math.pow(10,i));
        }
        System.out.println(answer);
        return answer;
    }

}
