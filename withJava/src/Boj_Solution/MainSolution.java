package Boj_Solution;

import java.io.IOException;

import Boj_Solution.bruteforce.Boj_2992;
import Boj_Solution.datastructure.Boj_10876;
import Boj_Solution.datastructure.Boj_5052;
import Boj_Solution.greedy.Boj_1946;
import Boj_Solution.implemention.Boj_1010;
import Boj_Solution.programmers.level1.Prog_005;

public class MainSolution {

    public static void main(String[] args) throws IOException {
        int[] solution = new Prog_005().solution(new String[] {"muzi", "frodo", "apeach", "neo"},
            new String[] {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
    }

}




