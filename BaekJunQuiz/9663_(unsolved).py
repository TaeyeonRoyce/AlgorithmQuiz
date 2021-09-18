N = int(input())

chessBoard = []
for i in range(N):
    newList = []
    for j in range(N):
        newList.append(False)
    chessBoard.append(newList)

caseCount = 0
def solution(currentChessBoard, depth, cntQueen, N, cnt):
    previousChessBoard = currentChessBoard
    for x in range(N):
        if currentChessBoard[depth][x] == False:
            cntQueen += 1
            movement = 1
            for i in range(0,N):  #가로축
                currentChessBoard[depth][i] = True
            for i in range(depth + 1, N): #세로축
                currentChessBoard[i][x] = True
            while x + movement < N and depth + movement < N :  #우측아래 대각선
                currentChessBoard[depth + movement][x+movement]= True
                movement += 1
            movement = 1
            while x - movement > N and depth + movement < N :  #좌측아래 대각선
                currentChessBoard[depth + movement][x - movement] = True
                movement += 1
            if cntQueen == N:
                cnt += 1
                return previousChessBoard
            elif depth == N - 1:
                return previousChessBoard
            currentChessBoard = solution(currentChessBoard, depth + 1, cntQueen + 1, N, cnt)


print(chessBoard)
print(solution(chessBoard, 0, 0, N, 0))
            

    