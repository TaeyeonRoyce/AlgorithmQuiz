N, M, Y, X, K = map(int, input().split())
board = []
board.append([11]*(M+2))
for i in range(N):
    line = []
    line.append(11)
    lineValue = list(map(int, input().split()))
    for i in lineValue:
        line.append(i)
    line.append(11)
    board.append(line)
board.append([11]*(M+2))
cmdList = list(map(int, input().split()))
locationY = Y+1
locationX = X+1

def check(locationX, locationY, board):
    if board[locationY][locationX] == 11:
        return False
    else:
        return True
# def rollDice(way, dice):
#     if way == 1:
        
#     elif way == 2:

dice = [[0,0,0],[0,0,0],[0,0,0],[0,0,0]]

for i in range(K):
    isAvail = True
    cmdWay = cmdList[i]
    if cmdWay == 1:
        isAvail = check(locationX + 1, locationY, board)
        if isAvail == False:
            continue
        locationX += 1
    elif cmdWay == 2: 
        isAvail = check(locationX - 1, locationY, board)
        if isAvail == False:
            continue
        locationX -= 1
    elif cmdWay == 3: 
        isAvail = check(locationX, locationY - 1, board)
        if isAvail == False:
            continue
        locationY -= 1
    elif cmdWay == 4:    
        isAvail = check(locationX, locationY + 1, board)
        if isAvail == False:
            continue
        locationY += 1
        if board[locationY][locationX] == 0:
            board[locationY][locationX] == dice[1][2]
        else:
            dice[1][2] = board[locationY][locationX]
            board[locationY][locationX] = 0
        




