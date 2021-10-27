N, M = map(int, input().split())
board = []
for i in range(N):
    K = list(map(int, input().split()))
    board.append(K)
answer = 0

for i in range(N):
    for j in range(M-3):
        sumNum = 0
        sumNum = board[i][j] + board[i][j+1] + board[i][j+2] + board[i][j+3]
        if sumNum > answer:
            answer = sumNum
for i in range(N-3):
    for j in range(M):
        sumNum = 0
        sumNum = board[i][j] + board[i+1][j] + board[i+2][j] + board[i+3][j]
        if sumNum > answer:
            answer = sumNum
for i in range(N-1):
    for j in range(M-1):
        sumNum = 0
        sumNum = board[i][j] + board[i+1][j] + board[i][j+1] + board[i+1][j+1]
        if sumNum > answer:
            answer = sumNum

for i in range(N-1):
    for j in range(M-2):
        numBox = [board[i][j],board[i][j+1],board[i][j+2],board[i+1][j],board[i+1][j+1],board[i+1][j+2]]
        difBox = [numBox[0]+numBox[1], numBox[0]+numBox[2], numBox[0] + numBox[5], numBox[3] + numBox[4], numBox[3] + numBox[5], numBox[3] + numBox[2], numBox[1] + numBox[2], numBox[4] + numBox[5]]
        sumNum = sum(numBox) - min(difBox)
        if sumNum > answer:
            answer = sumNum

for i in range(N-2):
    for j in range(M-1):
        sumNum = 0
        numBox = [board[i][j],board[i][j+1],board[i+1][j],board[i+1][j+1],board[i+2][j],board[i+2][j+1]]
        difBox = [numBox[0]+numBox[2], numBox[0]+numBox[4], numBox[0] + numBox[5], numBox[1] + numBox[3], numBox[1] + numBox[4], numBox[1] + numBox[5], numBox[2] + numBox[4], numBox[3] + numBox[5]]
        sumNum = sum(numBox) - min(difBox)
        if sumNum > answer:
            answer = sumNum
print(answer)