package Boj_Solution.datastructure;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Boj_2164 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            deque.add(i);
        }
        while (deque.size() != 1) {
            deque.pollFirst();
            deque.add(deque.pollFirst());
        }
        System.out.println(deque.getFirst());
    }
}
