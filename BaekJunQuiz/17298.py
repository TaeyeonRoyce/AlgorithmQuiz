import sys
N = int(input())
userInput = list(map(int, sys.stdin.readline().split()))
stack = []
stack.append(0)
answerList = [-1 for _ in range(N)]

for i in range(1, len(userInput)):
    while stack and userInput[stack[-1]] < userInput[i]:
        answerList[stack[-1]] = userInput[i]
        stack.pop()
    stack.append(i)
print(*answerList)