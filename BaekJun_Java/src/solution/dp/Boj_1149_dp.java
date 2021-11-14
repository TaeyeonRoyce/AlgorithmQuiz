package solution.dp;

import java.util.Scanner;


public class Boj_1149_dp {
    int[][] houses;
    int N;
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        this.N = inputs.nextInt();
        this.houses = new int[N][3];
        for (int i = 0; i < N; i++) {
            houses[i][0] = inputs.nextInt();
            houses[i][1] = inputs.nextInt();
            houses[i][2] = inputs.nextInt();
        }
        for (int i = 1; i < N; i++){
            houses[i][0] = sumNextHouse(i, 0);
            houses[i][1] = sumNextHouse(i, 1);
            houses[i][2] = sumNextHouse(i, 2);
        }
        System.out.println(printAnswer());
    }

    private int sumNextHouse(int house, int rgb){
        int[] getPreHouse = houses[house - 1];
        int[] getCurrHouse = houses[house];
        int nextHouse = 0;
        if (rgb == 0){
            nextHouse += getCurrHouse[0];
            nextHouse += getPreHouse[1] > getPreHouse[2] ? getPreHouse[2] : getPreHouse[1];
        } else if (rgb == 1){
            nextHouse += getCurrHouse[1];
            nextHouse += getPreHouse[0] > getPreHouse[2] ? getPreHouse[2] : getPreHouse[0];
        } else if (rgb == 2){
            nextHouse += getCurrHouse[2];
            nextHouse += getPreHouse[0] > getPreHouse[1] ? getPreHouse[1] : getPreHouse[0];
        }
        return nextHouse;
    }
    private int printAnswer() {
        int answer = houses[N - 1][0];
        if (houses[N - 1][1] < answer) {
            answer = houses[N - 1][1];
        }
        if (houses[N - 1][2] < answer){
            answer = houses[N - 1][2];
        }
        return answer;
    }

}
