import sys

N = int(input())
newStack = []

for i in range(N):
    userInput = sys.stdin.readline().strip()
    if userInput == "pop":
        if len(newStack) == 0:
            print("-1")
        else:
            print(newStack[-1])
            newStack.pop()
    elif userInput == "size":
        print(len(newStack))
    elif userInput == "top":
        if len(newStack) == 0:
            print("-1")
        else:
            print(newStack[-1])
    elif userInput == "empty":
        if len(newStack) == 0:
            print("1")
        else:
            print("0")
    else:
        pushNumber = userInput.split()[-1]
        newStack.append(int(pushNumber))