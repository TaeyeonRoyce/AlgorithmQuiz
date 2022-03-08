package socarTest;

import java.util.Arrays;

public class ArraySolution {
    int[] arr = new int[]{4, 7, 10, 3, 5};
    int K = 4;

    // {4,7,5,3,10}
    // {4,3,5,7,10}
    // ans ==> 2

    int diff = 8;

    public void solution() {
        if (!isAvailable()) {
            System.out.println("-1");
        }


        // arr를 순열로 돌림 (모든 경우의 수)
        // 원래 arr과 비교하며 다른 원소의 수를 저장하여 다른 갯수 셈
        // {4, 7, 10, 3, 5}랑 정답{4, 3, 5, 7, 10}의 diff = 4
        // diff로 최소 스왑 구하려다 못함

    }

    private boolean isAvailable() {
        int[] clone = arr.clone();
        Arrays.sort(clone);
        for (int i = 0; i < clone.length - 1; i++) {
            if (clone[i] - clone[i + 1] > K) {
                return false;
            }
        }
        return true;
    }
}
