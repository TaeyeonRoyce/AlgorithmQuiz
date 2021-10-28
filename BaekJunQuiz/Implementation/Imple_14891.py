from collections import deque

gearA = deque(input())
gearB = deque(input())
gearC = deque(input())
gearD = deque(input())
board = [gearA, gearB, gearC, gearD]
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
    turnQueue = [0,0,0,0]
    turnQueue[turnGear-1] = direction
    preDirect = direction
    for i in range(turnGear, 4):
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
    for i in range(4 - (turnGear-1), 4):
        i = 4 - (i+1)
        if board[i+1][6] == board[i][2]:
            break
        else:
            if preDirect == 1:
                turnQueue[i] = -1
                preDirect = -1
            elif preDirect == -1:
                turnQueue[i] = 1
                preDirect = 1

    for i in range(4):
        if turnQueue[i] == 1:
            board[i] = TurnClockWise(board[i])
        elif turnQueue[i] == -1:
            board[i] = TurnCounterClockWise(board[i])
cnt = 0
for i in board:
    answer += int(i[0])*(2**(cnt))
    cnt += 1
print(answer)