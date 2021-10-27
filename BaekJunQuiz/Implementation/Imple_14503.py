N, M = map(int, input().split())
RandC = list(map(int, input().split()))
board = []
X = RandC[1]
Y = RandC[0]
D = RandC[2]
for i in range(N):
    line = list(map(int, input().split()))
    board.append(line)
answer = 0
while 1:
    currentLoactionValue = board[Y][X] 
    if currentLoactionValue == 0:
        answer += 1
        board[Y][X] = 1.1
    if int(board[Y][X-1]) == 1 and int(board[Y][X+1]) == 1 and int(board[Y-1][X]) == 1 and int(board[Y+1][X]) == 1:
        if D == 0:
            if board[Y+1][X] == 1:
                break
            else:
                Y +=1
        elif D == 1:
            if board[Y][X-1] == 1:
                break
            else:
                X -=1
        elif D == 2:
            if board[Y-1][X] == 1:
                break
            else:
                Y -=1
        elif D == 3:
            if board[Y][X+1] == 1:
                break
            else:
                X +=1
    else:
        if D == 0:
            if board[Y][X-1] == 0:
                X -= 1
                D = 3
                continue

            elif int(board[Y][X-1]) == 1:
                D = 3

        if D == 3:
            if board[Y+1][X] == 0:
                Y += 1
                D = 2
                continue
            elif int(board[Y+1][X]) == 1:
                D = 2

        if D == 2:
            if board[Y][X+1] == 0:
                X += 1
                D = 1
                continue
            elif int(board[Y][X+1]) == 1:
                D = 1

        if D == 1:
            if board[Y-1][X] == 0:
                Y -= 1
                D = 0
                continue
            elif int(board[Y-1][X]) == 1:
                D = 0

print(answer) 


        


