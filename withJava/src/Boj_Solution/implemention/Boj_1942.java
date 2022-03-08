package Boj_Solution.implemention;

import java.util.Scanner;

/* 2007년 */
public class Boj_1942 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int month = inputs.nextInt();
        int dayGap = inputs.nextInt();
        inputs.close();
        String[] weekdays = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        for (int i = 1; i < month; i++){
            if (i == 2){
                dayGap += 28;
            }else if(i == 4
                    || i == 6
                    || i == 9
                    || i == 11){
                dayGap += 30;
            }else{
                dayGap += 31;
            }
        }
        System.out.println(weekdays[(dayGap-1)%7]);
    }
}
