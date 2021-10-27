N = int(input())
K = int(input())
board = []
board.append([1]*(N+2))
for i in range(N):
    line = [1]
    for j in range(N):
        line.append(0)
    line.append(1)
    board.append(line)
board.append([1]*(N+2))
for i in range(K):
    Y,X = map(int, input().split())
    board[Y][X] = 10
L = int(input())
turnTime = []
turnWay = []
for i in range(L):
    L,D = input().split()
    turnTime.append(int(L))
    turnWay.append(D)
sec = 0
headCursor = [1,1]
tailCursor = [1,1]
body = [[1,1]]
directWay = 1
board[1][1] = 1
while 1:
    sec += 1
    if directWay % 4 == 1:
        headCursor[1] += 1
    elif directWay % 4 == 2:
        headCursor[0] += 1
    elif directWay % 4 == 3:
        headCursor[1] -= 1
    elif directWay % 4 == 0:
        headCursor[0] -= 1

    if board[headCursor[0]][headCursor[1]] == 1:
        break;
    elif board[headCursor[0]][headCursor[1]] == 10:
        board[headCursor[0]][headCursor[1]] = 1
        body.append([headCursor[0],headCursor[1]])
    else:
        board[headCursor[0]][headCursor[1]] = 1
        board[body[0][0]][body[0][1]] = 0
        body.pop(0)
        body.append([headCursor[0],headCursor[1]])
    if len(turnTime) > 0 and sec == turnTime[0]:
        if turnWay[0] == "D":
            directWay += 1
        elif turnWay[0] == "L":
            directWay -= 1
        turnTime.pop(0)
        turnWay.pop(0)
print(sec)
