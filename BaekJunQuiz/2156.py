import sys
N = int(input())
userInput = [int(sys.stdin.readline().strip()) for _ in range(N)]
total = sum(userInput)  #전체 포도주량의 합

#diff는 못마시는 포도주의 합


def solution(ls, diff, cursor, minSum):
    if diff > minSum:
        return minSum
    if cursor >= len(ls):
        if minSum > diff:
            return diff
        else:
            return minSum
    
    for i in range(2): #연속해서 최대 2잔은 마실 수 있음
        if cursor >= 2 and ls[cursor - 1] == 0 and ls[cursor - 2] == 0: #연속해서 포도주를 3번 안마실때는 패스
            pass
        diff += ls[cursor - i]  #안마실 포도주
        minSum = solution(ls, diff, cursor - i + 3, minSum)  #탐색
        diff -= ls[cursor - i] #안마실 포도주를 다시 선택하기 위해 되돌림
    return minSum

print(total - solution(userInput, 0, 2, total))