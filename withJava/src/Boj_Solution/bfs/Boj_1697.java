package Boj_Solution.bfs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Boj_1697 {

    int[] dx = {-1, 1, 0};
    int answer = 0;
    int K;

    public void solution(){
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        this.K = inputs.nextInt();
        if (K == N){
            answer = 0;
        }else if (K < N){
            answer = N - K;
        }else {
            bfs(N);
        }
        System.out.println(answer);

    }
    private void bfs(int a){
        boolean[] checks = new boolean[K*2+1];
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[] startLocation = {a, 0};
        checks[a] = true;
        deque.add(startLocation);
        while(true){
            int[] inProcess = deque.pollFirst();
            int location = inProcess[0];
            int count = inProcess[1];
            if (location == K){
                answer = count;
                return;
            }
            for (int i : dx){
                int movedLocation = 0;
                if (i == 0){
                    movedLocation = location*2;
                }
                else{
                    movedLocation = location + i;
                }
                if ( 0 <= movedLocation && movedLocation < K*2 && !checks[movedLocation]) {
                    deque.add(new int[]{movedLocation, count + 1});
                    checks[movedLocation] = true;
                }
            }
        }
    }
}
