N, K = map(int,input().split())
memo = [[0]*(K) for i in range(N)]

divider = 1000000000
for i in range(K):
    memo[0][i] = i + 1
for i in range(N):
    memo[i][0] = 1
for i in range(1, N):
    for j in range(1,K):
        memo[i][j] = (memo[i-1][j]+ memo[i][j-1])%divider
print(memo[-1][-1])