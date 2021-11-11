package solution.greedy;

import java.util.Scanner;

public class Boj_11047 {
    private int K;
    private int answer = 0;
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        this.K = inputs.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++){
            int coin = inputs.nextInt();
            coins[i] = coin;
        }
        while(K > 0){
            fillCoin(coins[N-1]);
            N -= 1;
        }
        System.out.println(answer);
    }
    private void fillCoin(int coin){
        while(coin <= K){
            K -= coin;
            answer += 1;
        }
    }
}

