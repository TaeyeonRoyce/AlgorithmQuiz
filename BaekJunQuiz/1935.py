import sys

N = int(input())

def calculation(ops,b,a):
    if ops == "+":
        return a + b
    elif ops == "-":
        return a - b
    elif ops == "*":
        return a * b
    elif ops == "/":
        return a / b

alphaList = [chr(x) for x in range(65, 65 + N)]
operator = ["+", "-", "*", "/"]
formula = input()
numberDict = {}
for i in range(N):
    numberDict[alphaList[i]] = int(sys.stdin.readline())
stack = []
for i in formula:
    if i in operator:
        stack.append(calculation(i, stack.pop(), stack.pop()))
    else:
        stack.append(numberDict[i])
print('{:.2f}'.format(stack[-1]))
