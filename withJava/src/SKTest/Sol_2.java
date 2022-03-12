package SKTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sol_2 {
	static int[][] board;

	public static void main(String[] args) {
		solution(6, false);
		for (int[] ints : board) {
			System.out.println(Arrays.toString(ints));
		}
	}

	public static int[][] solution(int n, boolean clockwise) {
		int[][] answer = {};

		int endPoint = 1;

		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0; //방문 이전임을 표시
			}
		}

		//endPoint 구하기
		//ex) n = 9인 경우,
		//board의 종점은 21인데, 대각선 방향으로 1, 9, 15, 19, 21로 증가한다.
		//그 증가 폭이 8, 6, 4, 2라는 규칙을 얻을 수 있고,
		//홀수와 짝수를 나누어 모든 수에 대한 종점을 구하는 규칙을 구현하였다.
		if (n % 2 == 0) {
			int gap = n - 1;
			for (int i = 1; i < n / 2; i++) {
				endPoint += gap;
				gap -= 2;
			}
		} else if (n % 2 == 1) {
			int gap = n - 1;
			for (int i = 0; i < n / 2; i++) {
				endPoint += gap;
				gap -= 2;
			}
		}

		int num = 1; //시작점
		List<Arrow> arrows = new ArrayList<>();

		//Arrow라는 클래스는 다음과 같은 역할을 가진다
		//화살표의 위치와 진행방향, 회전방향(clockwise)
		//위치와 방향에 따라 이동하는 moveOn(),
		//회전 방향에 따라 회전하는 turnByClockwise()가 존재한다.
		if (clockwise) {
			arrows.add(new Arrow(0, 0, clockwise, Direction.RIGHT, num));
			arrows.add(new Arrow(0, n - 1, clockwise, Direction.DOWN, num));
			arrows.add(new Arrow(n - 1, 0, clockwise, Direction.UP, num));
			arrows.add(new Arrow(n - 1, n - 1, clockwise, Direction.LEFT, num));
		} else if (!clockwise) {
			arrows.add(new Arrow(0, 0, clockwise, Direction.DOWN, num));
			arrows.add(new Arrow(0, n - 1, clockwise, Direction.LEFT, num));
			arrows.add(new Arrow(n - 1, 0, clockwise, Direction.RIGHT, num));
			arrows.add(new Arrow(n - 1, n - 1, clockwise, Direction.UP, num));
		}

		//N이 짝수인 경우 endPoint까지 진행
		if (n % 2 == 0) {
			for (int i = 0; i < endPoint; i++) {
				for (Arrow arrow : arrows) {
					arrow.moveOn(board);
				}
			}
		}
		//N이 홀수인 경우, endPoint까지 진행하면 Arrow.moveOn()의 충돌이 일어남. (종점이 한 점으로 존재하기 때문)
		//마지막 하나의 종점을 채우는 moveOn()은 한 번만 호출 되도록 반복문에서 분리
		else if (n % 2 == 1) {
			for (int i = 0; i < endPoint - 1; i++) {
				for (Arrow arrow : arrows) {
					arrow.moveOn(board);
				}
			}
			arrows.get(0).moveOn(board);
		}

		answer = board;
		return answer;
	}
}

class Arrow {
	Direction direction;
	boolean clockwise;
	int y;
	int x;
	int num;

	public Arrow(int y, int x, boolean clockwise, Direction direction, int num) {
		this.direction = direction;
		this.clockwise = clockwise;
		this.y = y;
		this.x = x;
		this.num = num;
	}

	public void moveOn(int[][] board) {
		if (board[y][x] == 0) {
			board[y][x] = num;
			return;
		}
		int nextX = x;
		int nextY = y;
		switch (direction) {
			case UP:
				nextY -= 1;
				break;
			case RIGHT:
				nextX += 1;
				break;
			case DOWN:
				nextY += 1;
				break;
			case LEFT:
				nextX -= 1;
		}

		//다른 화살표가 방문한 적 있는 위치인 경우 회전, 아니면 계속 이동
		if (board[nextY][nextX] == 0) {
			board[nextY][nextX] = ++num;
			x = nextX;
			y = nextY;
		} else {
			turnByClockwise(this.clockwise);
			moveOn(board);
		}
	}

	//Clockwise에 따라 우측, 혹은 좌측으로 회전
	private void turnByClockwise(boolean clockwise) {
		if (clockwise) {
			this.direction = Direction.turnRight(this.direction);
			return;
		}
		this.direction = Direction.turnLeft(this.direction);
	}
}

enum Direction {
	UP,
	DOWN,
	LEFT,
	RIGHT;

	public static Direction turnRight(Direction direction) {
		switch (direction) {
			case UP:
				return RIGHT;
			case RIGHT:
				return DOWN;
			case DOWN:
				return LEFT;
			case LEFT:
				return UP;
		}
		return null;
	}

	public static Direction turnLeft(Direction direction) {
		switch (direction) {
			case UP:
				return LEFT;
			case RIGHT:
				return UP;
			case DOWN:
				return RIGHT;
			case LEFT:
				return DOWN;
		}
		return null;
	}
}
