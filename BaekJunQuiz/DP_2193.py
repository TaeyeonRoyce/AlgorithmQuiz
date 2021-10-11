#이친수

N = int(input())
memo = [[0,0] for i in range(N)]
memo[0][1] = 1
for i in range(1,N):
    memo[i][0] = memo[i-1][0] + memo[i-1][1]
    memo[i][1] = memo[i-1][0]
print(sum(memo[-1]))