from collections import deque

T = int(input())
for _ in range(T):
    func = input()
    length = int(input())
    intArr = deque(input()[1:-1].split(","))
    isERR = False
    reverseCnt = 0
    for i in func:
        if i == 'R':
            reverseCnt += 1
        elif i == 'D':
            if len(intArr) == 0 or length == 0:
                isERR = True
                break
            else:
                if reverseCnt % 2 == 0:
                    intArr.popleft()
                else:
                    intArr.pop()
    if reverseCnt % 2 == 1:
        intArr.reverse()
    if isERR:
        print("error")
    else:
        print('['+','.join(intArr)+']')