from collections import deque
N, L, R = map(int, input().split())
board = []
for i in range(N):
    line = list(map(int, input().split()))
    board.append(line)
answer = 0

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
def bfs(i, j):
    q = deque()
    q.append([i, j])
    unionLocation = [[i, j]]
    while q:
        y, x = q.popleft()
        for i in range(4):
            cursorY = y + dy[i]
            cursorX = x + dx[i]
            if cursorY >= N or cursorY < 0 or cursorX >= N or cursorX < 0:
                continue
            else:
                if checkBoard[cursorY][cursorX] == True :
                    continue
                elif L <= abs(board[cursorY][cursorX] - board[y][x]) and abs(board[cursorY][cursorX] - board[y][x]) <= R:
                    checkBoard[cursorY][cursorX] = True
                    q.append([cursorY, cursorX])
                    unionLocation.append([cursorY, cursorX])
    return unionLocation

while 1:
    checkBoard = []
    for i in range(N):
        checkBoard.append([False]*N)
    isBreak = True
    dividedPopulation = 0
    for i in range(N):
        for j in range(N):
            if checkBoard[i][j] == False:
                checkBoard[i][j] = True
                union = bfs(i,j)
                if len(union) > 1:
                    dividedPopulation = 0
                    isBreak = False
                    for k in union:
                        dividedPopulation += board[k[0]][k[1]]
                    dividedPopulation /= len(union)
                    for k in union:
                        board[k[0]][k[1]] = int(dividedPopulation)
    if isBreak == True:
        break
    answer += 1
print(answer)