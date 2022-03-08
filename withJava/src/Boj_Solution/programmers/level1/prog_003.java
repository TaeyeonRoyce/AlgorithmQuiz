package Boj_Solution.programmers.level1;

public class prog_003 {
    public void solution(){
        int[] inputs = {1,2,3,4,6,7,8,0};
        main_solution(inputs);
    }

    public int main_solution(int[] numbers) {
        int answer = 45;
        for (int i = 0; i < numbers.length; i++){
            answer -= numbers[i];
        }
        System.out.println(answer);
        return answer;
    }

}
