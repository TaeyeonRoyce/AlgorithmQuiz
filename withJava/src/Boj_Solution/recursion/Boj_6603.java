package Boj_Solution.recursion;

import java.util.Scanner;

public class Boj_6603 {
    int[] nums;
    boolean[] answer;
    int K;
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        while(true){
            K = inputs.nextInt();
            if(K == 0){
                break;
            }
            answer = new boolean[K];
            nums = new int[K];
            for (int i = 0; i < K; i++) {
                nums[i] = inputs.nextInt();
            }
            recursion(0,0);
            System.out.println();
        }
    }
    private void recursion(int depth, int startLocation) {
        if (depth == 6){
            for (int i = 0; i < K; i++) {
                if(answer[i]){
                    System.out.print(nums[i] + " ");
                }
            }
            System.out.println();
        } else {
            for (int i = startLocation; i < K ; i++) {
                answer[i] = true;
                recursion(depth+1, i+1);
                answer[i] = false;
            }
        }
    }
}
