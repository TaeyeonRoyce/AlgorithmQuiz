/**
 * 문제 해결 과정
 * 1. 부족한 괄호 찾기
 * 2. 부족한 괄호 문자을 주어진 문자열(input)의 모든 위치에 추가
 * 	2.1 부족한 괄호가 추가된 문자열에 대해서 완전한 괄호 문자열인지 확인
 * 	 -> 완전한 괄호 문자열이면 answer += 1
 */

package socarTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracketSolution {

	public void solution(String input) {
		BracketService bs = new BracketService();
		bs.createBracketTypes();

		//어떤 괄호가 부족한지 찾는 메서드
		//ex. "()(){{}" -> "}"을 반환
		String[] split = input.split("");
		String missedBracket = bs.findMissedBracket(split);

		//찾아낸 부족한 문자열을 활용하여 정답 구하기
		int answer = bs.getAnswerByMissedBracket(missedBracket, split);

		System.out.println("answer = " + answer);

		//갯수 찾는 방법
		// 1. 하나씩 넣어서 조회하기
		// 2. 규칙을 찾아서 합 구하기
	}
}

class BracketService {
	private List<Bracket> brackets = new ArrayList<>();

	public void createBracketTypes() {
		this.brackets.add(new Bracket("[", "]"));
		this.brackets.add(new Bracket("{", "}"));
		this.brackets.add(new Bracket("(", ")"));
	}

	public String findMissedBracket(String[] input) {
		/**
		수행 로직
		 splitInput = [ "(", ")", "(", ")", "{", "{", "}" ]와
		 brackets = [ "[]", "{}", "()" ] 에 대하여
		*/
		for (String s : input) {
			for (Bracket bracket : brackets) {
				if (bracket.isFitBracket(s) // 동일한 종류의 괄호에 대해서,
						&& !bracket.checkStack(s)) // 괄호쌍을 이루지 않는경우
					return bracket.findOpposite(s);// 짝을 이루지 못한 괄호의 짝을 반환
			}

		}

		//위 로직을 거치면, 부족한 괄호가 왼쪽("[")인 경우 찾아내지 못하고 남아있음.
		//"{{}" -> "{" -> true
		//모든 괄호객체의 Stack을 확인하여 남아있는 괄호의 짝을 반환
		for (Bracket bracket : brackets) {
			Stack<String> stack = bracket.getStack();
			if (stack.size() > 0)
				return bracket.findOpposite(stack.peek());
		}
		return null;
	}

	public int getAnswerByMissedBracket(String missedBracket, String[] split) {
		int answer = 0;

		//문자열에 추가할 수 있는 모든 곳에 부족한 괄호를 추가하기
		for (int i = 0; i < split.length + 1; i++) {
			String[] addedInput = addMissedBracket(missedBracket, split, i);

			if (isCompleteString(addedInput)) { //추가된 문자열이 완전한 괄호문자열이면 answer += 1
				answer += 1;
			}
		}
		return answer;
	}

	//index위치에 missedBracket을 추가함
	private String[] addMissedBracket(String missedBracket, String[] split, int index) {
		String[] newSplit = new String[split.length + 1]; // 길이가 1이 더 큰 배열에

		//맨 마지막에 추가해야 하는 경우
		//모두 복사한 뒤 마지막에 missedBracket추가
		if (index == split.length) {
			for (int i = 0; i < split.length; i++) {
				newSplit[i] = split[i];
			}
			newSplit[newSplit.length - 1] = missedBracket;
			return newSplit;
		}

		//index위치를 제외하고 모두 복사
		//index위치에는 missedBracket
		int cursor = 0;
		int cursorN = 0;
		while (cursor < split.length) {
			if (cursor == index) {
				newSplit[cursorN] = missedBracket;
				cursorN++;
			}
			newSplit[cursorN] = split[cursor];
			cursor++;
			cursorN++;
		}

		return newSplit;
	}

	private boolean isCompleteString(String[] addedInput) {

		//반복 작업을 위해 이전 검증에 사용된 Stack의 내부를 비움
		for (Bracket bracket : brackets) {
			bracket.getStack().clear();
		}

		//findMissedBracket의 결과가 없으면, 완전한 문자열임을 보장
		if (findMissedBracket(addedInput) == null) {
			return true;
		}
		return false;
	}
}

class Bracket {
	private String left;
	private String right;
	private Stack<String> stack = new Stack<>();

	public Bracket(String left, String right) {
		this.left = left;
		this.right = right;
	}

	// bracket종류 매칭 시켜 괄호의 종류를 파악.
	// "{" => "{}" true.
	// "{" => "()" false.
	public boolean isFitBracket(String singleBracket) {
		return singleBracket.equals(left) || singleBracket.equals(right);
	}

	// Stack에 열린 괄호와 닫힌 괄호를 추가
	// s => 열린 괄호인 경우 true,
	// s => 닫인 괄호인 경우
	//	stack에 짝이 되는 괄호가 있는경우만 true
	//ex.
	// Stack = ["("] 가 있다면,
	//	s => ")"일 경우 합쳐서 제거
	// Stack = [], s => ")"인 경우 false
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