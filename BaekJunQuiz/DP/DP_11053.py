#가장 긴 증가하는 부분 수열
N = int(input())
A = [int(x) for x in input().split()]

memo = [1 for x in range(N)]
for i in range(1, N):
    for j in range(i):
        if A[j] < A[i]:
            memo[i] = max(memo[i], memo[j]+ 1)
print(max(memo))