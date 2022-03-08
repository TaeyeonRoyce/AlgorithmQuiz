T = int(input())

def Boj_Solution(N):
    if N == 1:
        return memo[0]
    elif N == 2:
        return memo[1]
    elif N == 3:
        return memo[2]
    for i in range(4, N + 1):
        memo[i-1] = memo[i-2] + memo[i-3] + memo[i-4]
    return memo[N-1]

for _ in range(T):
    N = int(input())
    memo = [0]*(N+2)
    memo[0] = 1
    memo[1] = 2
    memo[2] = 4
    print(Boj_Solution(N))