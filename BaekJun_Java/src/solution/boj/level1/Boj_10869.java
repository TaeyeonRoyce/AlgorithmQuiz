package solution.boj.level1;

import java.util.Scanner;

class calcMethods{
    int A;
    int B;

    int add(int A, int B) {
        return A+B;
    }

    int substract(int A, int B) {
        return A-B;
    }

    int mutiply(int A, int B) {
        return A*B;
    }

    int divide(int A, int B) {
        return A / B;
    }

    int spare(int A, int B) {
        return A % B;
    }



}

public class Boj_10869 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int A = inputs.nextInt();
        int B = inputs.nextInt();
        inputs.close();
        calcMethods answer = new calcMethods();
        System.out.println(answer.add(A, B));
        System.out.println(answer.substract(A, B));
        System.out.println(answer.mutiply(A, B));
        System.out.println(answer.divide(A, B));
        System.out.println(answer.spare(A, B));


    }
}
