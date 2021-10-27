N = int(input())
digit = len(str(N))

def sumNumberAndDigit(n):
    nString = str(n)
    sum = 0
    for i in nString:
        sum += int(i)
    return n + sum

startRange = N - 9*digit
if startRange < 0:
    startRange = 0

for i in range(startRange,N):
    if sumNumberAndDigit(i) == N:
        print(i)
        break
    elif i == N - 1:
        print(0)
        break
