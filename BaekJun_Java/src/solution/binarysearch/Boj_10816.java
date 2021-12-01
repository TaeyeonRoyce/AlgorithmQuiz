package solution.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_10816 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        ArrayList<Integer> nums_1 = getNum(inputs);
        Collections.sort(nums_1);
        ArrayList<Integer> nums_2 = getNum(inputs);
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i : nums_2) {
            if (!nums_1.contains(i)) {
                answer.add(0);
            } else {
                answer.add(cnt(nums_1, i));
            }
        }
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    private ArrayList<Integer> getNum(Scanner inputs) {
        int N = inputs.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums.add(inputs.nextInt());
        }
        return nums;
    }

    private int cnt(ArrayList<Integer> arrayList, int num) {
        int max = arrayList.size();
        int min = 0;
        while (true) {
            int mid = min + ((max - min) / 2);
            if (arrayList.get(mid) > num) {
                max = mid;
            } else if (arrayList.get(mid) < num) {
                min = mid;
            } else if (arrayList.get(mid) == num) {
                int cnt = 0;
                while(mid >= 0 && arrayList.get(mid) == num) {
                    mid--;
                }
                mid++;
                while (mid < arrayList.size() && arrayList.get(mid) == num) {
                    cnt++;
                    mid++;
                }
                return cnt;
            }
        }
    }
}
