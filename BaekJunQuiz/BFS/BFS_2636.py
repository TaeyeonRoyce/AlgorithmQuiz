from collections import deque


N ,M = map(int, input().split())
board = []
for _ in range(N):
    line = list(map(int, input().split()))
    board.append(line)
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
answer = 0
def Boj_Solution():
    cheeseBoard = [[False]*M for _ in range(N)]
    q = deque()
    q.append([0,0])
    cheeseBoard[0][0] = True
    cnt = 0
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= nx < M and 0 <= ny < N and cheeseBoard[ny][nx] == False:
                if board[ny][nx] == 0:
                    q.append([ny,nx])
                elif board[ny][nx] == 1:
                    board[ny][nx] = 0
                    cnt += 1
                cheeseBoard[ny][nx] = True
    return cnt

while 1:
    cnt = Boj_Solution()
    if cnt == 0:
        break
    else:
        answer += 1
        preCnt = cnt
print(answer)
print(preCnt)
    


