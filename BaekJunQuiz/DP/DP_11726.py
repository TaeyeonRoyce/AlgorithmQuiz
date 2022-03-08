N = int(input())

memo = [0]*(N+2)
memo[1] = 1
memo[2] = 2
def Boj_Solution(N):
    if N == 1:
        return memo[1]
    elif N == 2:
        return memo[2]
    for i in range(3, N + 2):
        memo[i] = memo[i-2] + memo[i-1]
    return memo[N]
        



print(Boj_Solution(N) % 10007)