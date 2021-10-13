import sys

N = int(input())
A = [int(x) for x in sys.stdin.readline().split()]
sumList = []
sumList.append(A[0])
for i in range(1, len(A)):
    sumList.append(max(sumList[i-1] + A[i],A[i]))

print(max(sumList))