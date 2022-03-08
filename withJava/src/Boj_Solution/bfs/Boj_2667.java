package Boj_Solution.bfs;

import java.util.*;

public class Boj_2667 {

    int[][] board;
    int[] dx = {1, 0, -1, 0, 0};
    int[] dy = {0, 1, 0, -1, 0};

    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int[][] board = new int[N][N];
        int answerSection = 0;
        ArrayList<Integer> answerSectionSize = new ArrayList<>();
        for(int i=0; i < N; i++){
            String input = inputs.next();
            for(int j=0; j < N; j++){
                board[i][j] = input.charAt(j)-'0';
            }
        }

        this.board = board;

        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                if(board[j][i] == 1){
                    answerSectionSize.add(bfs(j, i, N));
                    answerSection += 1;
                }
            }
        }
        Collections.sort(answerSectionSize);
        System.out.println(answerSection);
        for (int i : answerSectionSize){
            System.out.println(i);
        }

    }

    private int bfs(int y, int x, int N){
        int cnt = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int[] location = {y, x};
        deque.add(location);

        while(!deque.isEmpty()){
            int[] inProcess = deque.pollFirst();
            int processY = inProcess[0];
            int processX = inProcess[1];
            for (int i = 0; i < 5; i ++){
                int positionX = processX + dx[i];
                int positionY = processY + dy[i];
                if (positionX >= 0  &&  positionX < N
                        && positionY >= 0 && positionY < N
                        && board[positionY][positionX] == 1){
                    board[positionY][positionX] = 0;
                    deque.offerLast(new int[]{positionY, positionX});
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
