N = int(input())
P = list(map(int, input().split()))
memo = [0]*(N+1)

memo[1] = P[0]
for i in range(2,N+1):
    memo[i] = P[i-1]
    for j in range(1,i):
        cmpNum = memo[i-j] + P[j-1]
        if cmpNum > memo[i]:
            memo[i] = cmpNum
print(memo[-1])