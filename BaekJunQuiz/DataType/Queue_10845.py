
import sys
from collections import deque

N = int(input())
newQueue = deque([])
for i in range(N):
    userInput = sys.stdin.readline().strip()
    if userInput == "pop":
        if len(newQueue) == 0:
            print("-1")
        else:
            print(newQueue.popleft())
    elif userInput == "size":
        print(len(newQueue))
    elif userInput == "top":
        if len(newQueue) == 0:
            print("-1")
        else:
            print(newQueue[-1])
    elif userInput == "empty":
        if len(newQueue) == 0:
            print("1")
        else:
            print("0")
    elif userInput == "front":
        if len(newQueue) == 0:
            print("-1")
        else:
            print(newQueue[0])
    elif userInput == "back":
        if len(newQueue) == 0:
            print("-1")
        else:
            print(newQueue[-1])
    else:
        pushNumber = userInput.split()[-1]
        newQueue.append(int(pushNumber))