package Boj_Solution.boj.level1;

import java.util.Scanner;

public class Boj_1316 {
    public void solution() {
        Scanner inputs = new Scanner(System.in);
        int N = inputs.nextInt();
        int answer = 0;
        for(int i = 0; i < N; i++){
            String word = inputs.next();
            answer += checkWord(word, word.length());
        }
        System.out.println(answer);

    }
    int checkWord(String word, int length){
        for (int i =1; i < length; i++){
            if (word.charAt(i) - word.charAt(i-1) != 0){
                char checkChr = word.charAt(i);
                for (int j = i - 1; j >= 0; j--){
                    if(word.charAt(j) == checkChr){
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}
