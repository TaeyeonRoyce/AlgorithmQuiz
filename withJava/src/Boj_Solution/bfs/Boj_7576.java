package Boj_Solution.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Boj_7576 {
    int[] dx = {1, 0, -1, 0, 0};
    int[] dy = {0, 1, 0, -1, 0};
    int M;
    int N;
    int answer = 0;
    int[][] board;
    ArrayList<int[]> tomatoInfo;
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        this.M = inputs.nextInt();
        this.N = inputs.nextInt();
        this.board = new int[N][M];
        this.tomatoInfo = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int boxInfo = inputs.nextInt();
                board[i][j] = boxInfo;
                if (boxInfo == 1){
                    tomatoInfo.add(new int[]{i, j});
                }
            }
        }
        bfs();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int locationInfo = board[i][j];
                if (locationInfo == 0){
                    System.out.println("-1");
                    return;
                }
                if (locationInfo > answer){
                    answer = locationInfo;
                }
            }
        }
        System.out.println(answer - 1);
    }
    private void bfs() {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        for (int[] i : tomatoInfo) {
            deque.add(i);
        }
        while (!deque.isEmpty()) {
            int[] inProcess = deque.pollFirst();
            int processY = inProcess[0];
            int processX = inProcess[1];
            for (int i = 0; i < 4; i++) {
                int positionX = processX + dx[i];
                int positionY = processY + dy[i];
                if (positionX >= 0 && positionX < M
                        && positionY >= 0 && positionY < N
                        && board[positionY][positionX] == 0) {
                    board[positionY][positionX] = board[processY][processX] + 1;
                    deque.add(new int[]{positionY, positionX});
                }
            }
        }
    }

}
