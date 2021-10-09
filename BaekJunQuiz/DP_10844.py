# 쉬운 계단 수
N = int(input())

memo = [[0]*10 for i in range(N)]
memo[0] = [0,1,1,1,1,1,1,1,1,1]

divde = 1000000000

for i in range(1,N):
    for j in range(0,10):
        if j == 0:
            memo[i][j]= memo[i-1][j+1] %divde
        elif j == 9:
            memo[i][j]= memo[i-1][j-1] %divde
        else:
            memo[i][j]= memo[i-1][j-1] %divde + memo[i-1][j+1] %divde
print(sum(memo[-1])%divde)