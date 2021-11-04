from collections import deque


X, Y = input().split()
diff = len(Y) - len(X)
X = deque(list(X))
Y = list(Y)
maxMatch = 0
for i in range(diff):
    X.append(0)
for _ in range(diff+1):
    sumDiff = 0
    sumCoin = 0
    for i in range(len(X)):
        if X[i] == Y[i]:
            sumCoin += 1
    if sumCoin > maxMatch:
        maxMatch = sumCoin
    X.appendleft(X.pop())
print(len(Y) - maxMatch - diff)
