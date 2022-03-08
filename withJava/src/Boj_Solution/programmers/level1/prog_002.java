package Boj_Solution.programmers.level1;

public class prog_002 {
    public void solution(){
        int[][] a = {{1,2},{2,3}};
        int[][] b = {{3,4},{5,6}};
        main_solution(a,b);
    }
    public int[][] main_solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for (int i = 0; i < arr1.length; i++){
            int[] ans = new int[arr1[0].length];
            int addAns;
            for(int j = 0; j < arr1[0].length; j++){
                addAns = arr1[i][j] + arr2[i][j];
                ans[j] = addAns;
            }
            answer[i] = ans;
        }

        return answer;
    }
}
