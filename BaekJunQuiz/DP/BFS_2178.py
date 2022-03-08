from collections import deque

N, M = map(int, input().split())
board = []
for _ in range(N):
    line = list(input())
    board.append(line)

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
answer = 0
def Boj_Solution():
    q = deque()
    q.append([0,0])
    board[0][0] = 1
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= nx < M and 0 <= ny < N and board[ny][nx] == "1":
                board[ny][nx] = board[y][x] + 1
                q.append([ny,nx])
Boj_Solution()
print(board[N-1][M-1])