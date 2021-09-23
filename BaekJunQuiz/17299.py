import sys
N = int(input())
userInput = list(map(int, sys.stdin.readline().split()))
stack = []
stack.append(0)
count = dict()
for i in userInput:
    try:
        count[i] += 1
    except:
        count[i] = 1

answerList = [-1 for _ in range(N)]

for i in range(1, len(userInput)):
    if i not in count:
        count[userInput[i]] = userInput.count(userInput[i])
    while stack and count[userInput[stack[-1]]] < count[userInput[i]]:
        answerList[stack[-1]] = userInput[i]
        stack.pop()
    stack.append(i)
print(*answerList)
