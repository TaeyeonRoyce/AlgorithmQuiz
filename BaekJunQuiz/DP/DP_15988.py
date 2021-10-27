T = int(input())
memo = [0,0,0]
memo[0] = 1
memo[1] = 2
memo[2] = 4

for i in range(T):
    N = int(input())
    if N > len(memo):
        for i in range(len(memo),N):
            memo.append((memo[i-3] + memo[i-2] + memo[i-1])%1000000009)
        print(memo[-1])
    else:
        print(memo[N-1])