package Boj_Solution.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1931 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int[][] meetingRooms = new int[N][2];
        for (int i = 0; i < N; i++) {
            meetingRooms[i][0] = inputs.nextInt();
            meetingRooms[i][1] = inputs.nextInt();
        }

        Arrays.sort(meetingRooms, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[1];
            } else {
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int preEndTime = 0;
        for(int i = 0; i < N; i++) {
            if(preEndTime <= meetingRooms[i][0]) {
                preEndTime = meetingRooms[i][1];
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
