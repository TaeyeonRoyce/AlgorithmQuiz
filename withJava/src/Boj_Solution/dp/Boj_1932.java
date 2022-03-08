package Boj_Solution.dp;

import java.util.Scanner;

public class Boj_1932 {

    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int n = inputs.nextInt();
        int[][] board = new int[n][n];
        int answer = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                int number = inputs.nextInt();
                if(i == 0 && j == 0) {
                } else if (j == 0) {
                    number += board[i - 1][j];
                } else if (j == i){
                    number += board[i - 1][j - 1];
                } else{
                    if (board[i - 1][j - 1] > board[i - 1][j]){
                        number += board[i - 1][j - 1];
                    }else{
                        number += board[i - 1][j];
                    }
                }
                board[i][j] = number;
            }
        }
        for (int i : board[n-1]) {
            if (i > answer){
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
