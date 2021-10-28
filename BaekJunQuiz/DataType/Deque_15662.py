from collections import deque

T = int(input())
board = []
for i in range(T):
    board.append(deque(input()))
K = int(input())
answer = 0

def TurnClockWise(gear):
    newGear = gear
    newGear.appendleft(newGear.pop())
    return newGear

def TurnCounterClockWise(gear):
    newGear = gear
    newGear.append(newGear.popleft())
    return newGear


for _ in range(K):
    turnGear, direction = map(int, input().split())
    turnQueue = [0]*T
    turnQueue[turnGear-1] = direction
    preDirect = direction
    for i in range(turnGear, T):
        if board[i-1][2] == board[i][6]:
            break
        else:
            if preDirect == 1:
                turnQueue[i] = -1
                preDirect = -1
            elif preDirect == -1:
                turnQueue[i] = 1
                preDirect = 1
    preDirect = direction
    for i in range(T - (turnGear-1), T):
        i = T - (i+1)
        if board[i+1][6] == board[i][2]:
            break
        else:
            if preDirect == 1:
                turnQueue[i] = -1
                preDirect = -1
            elif preDirect == -1:
                turnQueue[i] = 1
                preDirect = 1

    for i in range(T):
        if turnQueue[i] == 1:
            board[i] = TurnClockWise(board[i])
        elif turnQueue[i] == -1:
            board[i] = TurnCounterClockWise(board[i])
for i in board:
    if i[0] ==  "1":
        answer += 1
print(answer)