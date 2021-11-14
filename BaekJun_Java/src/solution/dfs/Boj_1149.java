package solution.dfs;

import java.util.Scanner;


//시간초과 남....
public class Boj_1149 {
    int[][] houses;
    int answer = 1000000; //1000 * 1000
    int N = 0;

    public void solution() {
        Scanner inputs = new Scanner(System.in);
        this.N = inputs.nextInt();
        this.houses = new int[N][3];
        for (int i = 0; i < N; i++) {
            houses[i][0] = inputs.nextInt();
            houses[i][1] = inputs.nextInt();
            houses[i][2] = inputs.nextInt();
        }
        dfs(0, 0, 0);
        dfs(1, 0, 0);
        dfs(2, 0, 0);
        System.out.println(answer);
    }
    private void dfs(int startIndex, int sum, int depth){
        if (depth == N){
            if (sum < answer) {
                answer = sum;
            }
            return;
        }

        if (startIndex == 0){
            dfs(1, sum + houses[depth][startIndex], depth + 1);
            dfs(2, sum + houses[depth][startIndex], depth + 1);
        } else if(startIndex == 1){
            dfs(0, sum + houses[depth][startIndex], depth + 1);
            dfs(2, sum + houses[depth][startIndex], depth + 1);
        } else if(startIndex == 2){
            dfs(0, sum + houses[depth][startIndex], depth + 1);
            dfs(1, sum + houses[depth][startIndex], depth + 1);
        }
    }
}
