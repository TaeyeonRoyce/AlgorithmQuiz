package socarTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracketSolution {
    String input = "()(()";

    public void solution() {
        BracketService bs = new BracketService();
        String missedBracket = bs.findMissedBracket(input);
        System.out.println("missedBracket = " + missedBracket);

        //갯수 찾는 방법
        // 1. 하나씩 넣어서 조회하기
        // 2. 규칙을 찾아서 합 구하기
    }
}

class BracketService {
    private List<Bracket> brackets = new ArrayList<>(Arrays.asList(
            new Bracket[]{new Bracket("["), new Bracket("{"), new Bracket("(")}));

    public String findMissedBracket(String input) {
        String[] splitInput = input.split("");

        for (String s : splitInput) {
            for (Bracket bracket : brackets) {
                if (bracket.isFit(s) && !bracket.checkStack(s)) return bracket.findOpposite(s);
            }
        }

        for (Bracket bracket : brackets) {
            Stack<String> stack = bracket.getStack();
            if (stack.size() > 0) return bracket.findOpposite(stack.peek());
        }
        return "";
    }
}

class Bracket {
    private String left;
    private String right;
    private Stack<String> stack = new Stack<>();

    public Bracket(String left) {
        if (left.equals("[")) {
            this.left = left;
            this.right = "]";
        } else if (left.equals("{")) {
            this.left = left;
            this.right = "}";
        } else if (left.equals("(")) {
            this.left = left;
            this.right = ")";
        }
    }

    public boolean isFit(String singleBracket) {
        return singleBracket.equals(left) || singleBracket.equals(right);
    }

    public boolean checkStack(String s) {
        if (s.equals(left)) {
            stack.add(s);
            return true;
        } else if (stack.isEmpty()) {
            return false;
        }
        stack.pop();
        return true;
    }

    public Stack<String> getStack() {
        return stack;
    }

    public String findOpposite(String bracket) {
        if (bracket.equals(left)) {
            return right;
        }
        return left;
    }
}