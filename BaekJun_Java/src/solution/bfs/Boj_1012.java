package solution.bfs;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Boj_1012 {
    int[][] board;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int N;
    int M;
    int answer;

    public void solution(){
        Scanner inputs = new Scanner(System.in);
        int T = inputs.nextInt();
        for (int test = 0; test < T; test++){
            this.M = inputs.nextInt();
            this.N = inputs.nextInt();
            int K = inputs.nextInt();
            this.board = new int[N][M];
            for (int i = 0; i < K; i++){
                int x = inputs.nextInt();
                int y = inputs.nextInt();
                board[y][x] = 1;
            }
            answer = 0;
            for (int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    int cursorX = j;
                    int cursorY = i;
                    if (board[cursorY][cursorX] == 1){
                        bfs(cursorX, cursorY);
                        answer += 1;
                    }
                }
            }
            System.out.println(answer);
        }
    }
    private void bfs(int x, int y) {
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[] location = {y, x};
        deque.add(location);

        while (!deque.isEmpty()) {
            int[] inProcess = deque.pollFirst();
            int processY = inProcess[0];
            int processX = inProcess[1];
            for (int i = 0; i < 4; i++) {
                int positionX = processX + dx[i];
                int positionY = processY + dy[i];
                if (positionX >= 0 && positionX < M
                        && positionY >= 0 && positionY < N
                        && board[positionY][positionX] == 1) {
                    board[positionY][positionX] = 0;
                    deque.offerLast(new int[]{positionY, positionX});
                }
            }
        }
    }
}
