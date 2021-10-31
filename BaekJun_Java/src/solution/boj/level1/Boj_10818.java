package solution.boj.level1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Boj_10818 {
    public void solution(){
        Scanner inputs = new Scanner(System.in);
        int A = inputs.nextInt();
        int[] arr = new int[A];
        for (int i = 0; i < A; i++){
            int B = inputs.nextInt();
            arr[i] = B;
        }
        inputs.close();
        //System.out.printf("%d %d",Arrays.stream(arr).min().getAsInt(),Arrays.stream(arr).max().getAsInt());
        Arrays.sort(arr);
        System.out.printf("%d %d",arr[0],arr[A-1]);

    }
}
