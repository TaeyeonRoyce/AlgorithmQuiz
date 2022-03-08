package Boj_Solution.programmers.level1;

public class prog_001 {
    public void solution(){
        main_solution(-12,5);
    }
    public long[] main_solution(int x, int n) {
        long[] answer = new long[n];
        for (long i = 0; i < n; i++){
            long ans = x*(i+1);
            answer[(int)i] = ans;
            System.out.println(answer[(int)i]);
        }

        return answer;
    }
}
